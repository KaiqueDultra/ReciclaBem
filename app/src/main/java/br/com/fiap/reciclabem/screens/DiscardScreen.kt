package br.com.fiap.reciclabem.screens

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import br.com.fiap.reciclabem.R
import br.com.fiap.reciclabem.components.LocationCard
import br.com.fiap.reciclabem.model.Endereco
import br.com.fiap.reciclabem.service.RetrofitFactory
import br.com.fiap.reciclabem.ui.theme.darknedApplicationColor
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun DiscardScreen() {

    var listAddressState by remember { mutableStateOf(listOf<Endereco>()) }

    val context = LocalContext.current

    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }

    var currentLocation by remember {
        mutableStateOf(LatLng(0.toDouble(),0.toDouble()))
    }

    val permissions = arrayOf(
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    @SuppressLint("MissingPermission")
    fun startLocationUpdates() {
        if (permissions.all {
                ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
            }) {
            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult) {
                    super.onLocationResult(p0)
                    for (location in p0.locations) {
                        currentLocation = LatLng(location.latitude, location.longitude)
                    }
                }
            }
            val locationRequest = LocationRequest.Builder(
                Priority.PRIORITY_HIGH_ACCURACY, 100
            )
                .setWaitForAccurateLocation(false)
                .setMinUpdateIntervalMillis(3000)
                .setMaxUpdateDelayMillis(100)
                .build()

            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        }
    }

    val launchMultiplePermissions = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionMaps ->
        val areGranted = permissionMaps.values.reduce { acc, next -> acc && next }
        if (areGranted) {
            startLocationUpdates()
            Toast.makeText(context, "Permissão autorizada", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Permissão negada", Toast.LENGTH_SHORT).show()
        }
    }

    Column {
        Column(
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth()
        ) {
        }
        Column(
            modifier = Modifier
                .weight(0.8f)
                .fillMaxWidth()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 23.dp, topEnd = 23.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    modifier = Modifier
                        .width(282.dp)
                        .height(210.dp)
                        .offset(y = (-112).dp),
                    painter = painterResource(id = R.drawable.group_recycling),
                    contentDescription = "Grupo reciclando"
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 90.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "ONDE DESCARTAR",
                        color = darknedApplicationColor,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Light
                    )
                    if (currentLocation.latitude != 0.0 && currentLocation.longitude != 0.0) {
                        val call = RetrofitFactory()
                            .getAddressService()
                            .getEnderecoByLatLng(
                                keyword = "reciclagem",
                                location = "${currentLocation.latitude},${currentLocation.longitude}",
                                rankby = "distance", key = "AIzaSyCTKSsAZLmVUCJpUeYUKGLgoKNXu4QZtjc"
                            )

                        call.enqueue(object : Callback<Endereco> {

                            override fun onResponse(
                                call: Call<Endereco>,
                                response: Response<Endereco>
                            ) {
                                response.body()!!.also { listAddressState = listOf(it) }
                            }

                            override fun onFailure(call: Call<Endereco>, t: Throwable) {
                                Log.i("MapsResponse", "onResponse: ${t.message}")
                            }

                        })
                    } else {
                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(top = 34.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(onClick = {
                                if (permissions.all {
                                        ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
                                    })
                                {
                                    startLocationUpdates()
                                }
                                else {
                                    launchMultiplePermissions.launch(permissions)
                                }
                            },
                            colors = ButtonDefaults.buttonColors(darknedApplicationColor)
                            ) {
                               Text(text = "Procurar locais")
                            }
                        }
                    }
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                    )
                    LazyColumn {
                        if(listAddressState.isNotEmpty()) {
                            items(listAddressState) { endereco ->
                                endereco.results.forEach {
                                    LocationCard(name = it.name, address = it.address, placeId = it.placeId, userLat = currentLocation.latitude, userLng = currentLocation.longitude, placeLat = it.geometry.location.lat, placeLng = it.geometry.location.lng)
                                }
                            }
                        } else {
                            item {
                               Column(
                                   modifier = Modifier
                                       .fillMaxSize()
                                       .padding(top = 34.dp),
                                   horizontalAlignment = Alignment.CenterHorizontally
                               ) {
                                   Text(
                                       text = "Carregando...",
                                       fontSize = 24.sp,
                                       fontWeight = FontWeight.Medium,
                                       color = darknedApplicationColor
                                   )
                               }
                            }
                        }
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )
    }
}
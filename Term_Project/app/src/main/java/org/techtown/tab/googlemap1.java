package org.techtown.tab;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;


public class googlemap1 extends AppCompatActivity implements AutoPermissionsListener {
    private static final String TAG = "MainActivity";

    SupportMapFragment mapFragment;
    GoogleMap map;
    MarkerOptions myLocationMarker;
    MarkerOptions marketMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googlemap1);

        Button backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d(TAG, "GoogleMap is ready.");

                map = googleMap;

                try {
                    map.setMyLocationEnabled(true);
                } catch(SecurityException e) {e.printStackTrace();}
            }
        });

        try {
            MapsInitializer.initialize(this);
        } catch(Exception e) {
            e.printStackTrace();
        }


               requestMyLocation();


        AutoPermissions.Companion.loadAllPermissions(this, 101);
    }


    private void requestMyLocation() {
        LocationManager manager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            long minTime = 10000;
            float minDistance = 0;
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    minTime,
                    minDistance,
                    new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            showCurrentLocation(location);
                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {
                        }

                        @Override
                        public void onProviderEnabled(String provider) {
                        }

                        @Override
                        public void onProviderDisabled(String provider) {
                        }
                    }
            );

            Location lastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                showCurrentLocation(lastLocation);
            }

            manager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    minTime,
                    minDistance,
                    new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            showCurrentLocation(location);

                            addPictures(location);
                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {
                        }

                        @Override
                        public void onProviderEnabled(String provider) {
                        }

                        @Override
                        public void onProviderDisabled(String provider) {
                        }
                    }
            );


        } catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    private void showCurrentLocation(Location location) {
        LatLng curPoint = new LatLng(35.8434208, 127.1258687);

        try {
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 16));

            showMyLocationMarker(location);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void showMyLocationMarker(Location location) {
        if (myLocationMarker == null) {
            myLocationMarker = new MarkerOptions();
            myLocationMarker.position(new LatLng(35.8385266, 127.1294467));
            myLocationMarker.title("- 내 위치 - ");
            myLocationMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocationicon));
            map.addMarker(myLocationMarker);
        } else {
            myLocationMarker.position(new LatLng(35.8385266, 127.1294467));
        }
    }

    private void addPictures(Location location) {
        int pictureResId = R.drawable.mylocation;
        Button mapbutton = findViewById(R.id.mapbutton);


        if (marketMarker == null) {
            marketMarker = new MarkerOptions();
            marketMarker.position(new LatLng(35.8434208, 127.1258687));
            marketMarker.title("- 전북대킹카 -" );

            marketMarker.icon(BitmapDescriptorFactory.fromResource(pictureResId));
            map.addMarker(marketMarker);

            mapbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(googlemap1.this);
                    // alert의 title과 Messege 세팅
                    myAlertBuilder.setTitle("- 전북대킹카 -");
                    myAlertBuilder.setMessage("● 전화번호 : 063 - 285 - 2901\n● 영업시간 : 09:00 ~ 18:00");

                    // 버튼 추가 ( 전화걸기 버튼 )
                    myAlertBuilder.setNeutralButton("전화걸기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:063-285-2901"));
                            startActivity(myIntent);
                        }
                    });

                    // 버튼 추가 ( Cancle 버튼 )
                    // 버튼 추가 ( Cancle 버튼 )
                    myAlertBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Cancle 버튼을 눌렸을 경우
                            Toast.makeText(getApplicationContext(), "감사합니다",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                    // Alert를 생성해주고 보여주는 메소드(show를 선언해야 Alert가 생성됨)
                    myAlertBuilder.show();

                }
            });

        } else {
            marketMarker.position(new LatLng(35.8434208, 127.1258687));
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (map != null) {
            try {
                map.setMyLocationEnabled(false);
            } catch(SecurityException e) {e.printStackTrace();}
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (map != null) {
            try {
                map.setMyLocationEnabled(true);
            } catch(SecurityException e) {e.printStackTrace();}
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
    }

    @Override
    public void onDenied(int requestCode, String[] permissions) {
        Toast.makeText(this, "permissions denied : " + permissions.length,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGranted(int requestCode, String[] permissions) {
        Toast.makeText(this, "permissions granted : " + permissions.length, Toast.LENGTH_LONG).show();
    }

}


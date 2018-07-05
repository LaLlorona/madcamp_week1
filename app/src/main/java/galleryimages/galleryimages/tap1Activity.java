package galleryimages.galleryimages;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class tap1Activity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String[] listItem;
    ArrayList<Human> h_info_list;
    HumanAdpter myadapter;

    private static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
                    return false;
            }
        }
        return true;
    }

    private static final int REQUEST_PERMISSIONS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tap1_layout);

        Button tap1 = (Button)findViewById(R.id.act1_tap1_btn);
        Button tap2 = (Button)findViewById(R.id.act1_tap2_btn);
        Button tap3 = (Button)findViewById(R.id.act1_tap3_btn);

        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(tap1Activity.this,
                    Manifest.permission.READ_CONTACTS)) {

            } else {
                ActivityCompat.requestPermissions(tap1Activity.this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        REQUEST_PERMISSIONS);
            }
        }else {

            int PERMISSION_ALL = 1;
            String[] PERMISSIONS = {Manifest.permission.READ_CONTACTS};
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);


            listView = (ListView) findViewById(R.id.listView);
            Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            String aNameFromContacts[] = new String[phones.getCount()];
            String aNumberFromContacts[] = new String[phones.getCount()];
            String contacts[] = new String[phones.getCount()];

            int i = 0;
            int nameFieldColumnIndex = phones.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            int numberFieldColumnIndex = phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

            h_info_list = new ArrayList<Human>();

            while (phones.moveToNext()) {
                Human newHuman = new Human(phones.getString(nameFieldColumnIndex), phones.getString(numberFieldColumnIndex), BitmapFactory.decodeResource(getResources(), R.drawable.contact));
                h_info_list.add(newHuman);
            }

            phones.close();

            myadapter = new HumanAdpter(getApplicationContext(),R.layout.mylist, h_info_list);
            listView.setAdapter(myadapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // TODO Auto-generated method stub
                    String value = myadapter.data.get(position).gender;
                    Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

                }
            });


            tap2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(myIntent);
                    overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
                    finish();
                }
            });
            tap3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(getApplicationContext(), tap3Activity.class);
                    startActivity(myIntent);
                    overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
                    finish();
                }
            });
        }
    }
}


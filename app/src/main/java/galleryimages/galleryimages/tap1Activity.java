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
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class tap1Activity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String[] listItem;

    private static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
                    return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tap1_layout);

        Button tap1 = (Button)findViewById(R.id.act1_tap1_btn);
        Button tap2 = (Button)findViewById(R.id.act1_tap2_btn);
        Button tap3 = (Button)findViewById(R.id.act1_tap3_btn);

        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {Manifest.permission.READ_CONTACTS};
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);

        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView);

        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        String aNameFromContacts[] = new String[phones.getCount()];
        String aNumberFromContacts[] = new String[phones.getCount()];
        String contacts[] = new String[phones.getCount()];

        int i = 0;
        int nameFieldColumnIndex = phones.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        int numberFieldColumnIndex = phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);


        while (phones.moveToNext())
        {
            String contactName = phones.getString(nameFieldColumnIndex);
            aNameFromContacts[i] =    contactName ;

            String number = phones.getString(numberFieldColumnIndex);
            aNumberFromContacts[i] =    number ;

            contacts[i] = contactName + " " + number;
            i++;
        }

        phones.close();
        listItem = contacts;
        //listItem = getResources().getStringArray(R.array.array_technology);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

            }
        });

        tap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(myIntent);
                overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_left);
                finish();
            }
        });
        tap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),tap3Activity.class);
                startActivity(myIntent);
                overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_left);
                finish();
            }
        });
    }
}


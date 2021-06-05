package sg.edu.rp.c346.id20022404.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {
    TextView DBS, OCBC, UOB;
    String wordClicked, dbsChin, ocbcChin, uobChin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.textViewBank1);
        registerForContextMenu(DBS);
        OCBC = findViewById(R.id.textViewBank2);
        registerForContextMenu(OCBC);
        UOB = findViewById(R.id.textViewBank3);
        registerForContextMenu(UOB);

        wordClicked = "";
        dbsChin = getString(R.string.chin1);
        ocbcChin = getString(R.string.chin2);
        uobChin = getString(R.string.chin3);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_mini,menu);

        if (v == DBS) {
            wordClicked = "DBS";
        } else if (v == OCBC) {
            wordClicked = "OCBC";
        } else if (v == UOB) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menu.add(0,0,100,"English");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.englishSelection) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");

        } else if (id == R.id.chineseSelection) {
            DBS.setText(dbsChin);
            OCBC.setText(ocbcChin);
            UOB.setText(uobChin);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.callSelection) {
            if (wordClicked.equalsIgnoreCase("dbs")) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                startActivity(i);

            } else if (wordClicked.equalsIgnoreCase("ocbc")){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18003633333"));
                startActivity(i);

            }  else if (wordClicked.equalsIgnoreCase("ocbc")) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                startActivity(i);

            }
            return true;

        } else if (id == R.id.websiteSelection) {
            if (wordClicked.equalsIgnoreCase("dbs")) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);

            } else if (wordClicked.equalsIgnoreCase("ocbc")){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(i);

            } else if (wordClicked.equalsIgnoreCase("uob")){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(i);

            }
            return true;

        } else if (id == R.id.toggleSelection) {
            if (wordClicked.equalsIgnoreCase("dbs")) {
                if (DBS.getCurrentTextColor() == Color.RED) {
                    DBS.setTextColor(Color.rgb(128,128,128));
                } else {
                    DBS.setTextColor(Color.RED);
                }

            } else if (wordClicked.equalsIgnoreCase("ocbc")){
                if (OCBC.getCurrentTextColor() == Color.RED) {
                    OCBC.setTextColor(Color.rgb(128,128,128));
                } else {
                    OCBC.setTextColor(Color.RED);
                }

            } else if (wordClicked.equalsIgnoreCase("uob")){
                if (UOB.getCurrentTextColor() == Color.RED) {
                    UOB.setTextColor(Color.rgb(128,128,128));
                } else {
                    UOB.setTextColor(Color.RED);
                }

            }
            return true;

        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}
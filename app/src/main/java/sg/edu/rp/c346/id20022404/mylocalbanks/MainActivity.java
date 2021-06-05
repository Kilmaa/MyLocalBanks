package sg.edu.rp.c346.id20022404.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView DBS, OCBC, UOB;
    String wordClicked;

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
            DBS.setText("星展银行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");

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

        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}
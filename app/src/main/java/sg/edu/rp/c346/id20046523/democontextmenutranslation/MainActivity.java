package sg.edu.rp.c346.id20046523.democontextmenutranslation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText, tvTranslatedText2;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText=findViewById(R.id.textViewTranslatedText);
        registerForContextMenu(tvTranslatedText); //long press, the below method will be called

        tvTranslatedText2=findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(tvTranslatedText2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        //groupid is used for grouping.
        //itemid known as menu id, needs to be unique!
        // order is like index, like who to appear first
        menu.add(0,0,0, "English");
        menu.add(0,1,1, "Italian");

        //v because to know which view it clicked
        if(v==tvTranslatedText)
        {
            //storing it in wordClicked variable
            wordClicked= "hello";
        }
        else if(v==tvTranslatedText2)
        {
            wordClicked="bye";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(wordClicked.equalsIgnoreCase("hello"))
        {
            if(item.getItemId()==0)
            {
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_LONG).show();
                tvTranslatedText.setText("Hello");
                return true;
            }
            else if(item.getItemId()==1)
            {
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_LONG).show();
                tvTranslatedText.setText("Ciao");
                return true;
            }
        }
        else if(wordClicked.equalsIgnoreCase("bye"))
        {
            if(item.getItemId()==0)
            {
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_LONG).show();
                tvTranslatedText2.setText("Bye");
                return true;
            }
            else if(item.getItemId()==1)
            {
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_LONG).show();
                tvTranslatedText2.setText("Addio");
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }
}
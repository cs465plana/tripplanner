package cs465.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.view.RowLayout;

import cs465.tripplanner.data.Data;

public class AddTagsActivity extends AddActivity {
    private ImageButton finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutId = R.layout.activity_add_tags;
        toolbarId = R.id.toolbar_add_tags;
        backId = R.id.tags_back_button;
        nextId = -1;
        backClass = AddDatesActivity.class;
        nextClass = null; // TODO
        super.onCreate(savedInstanceState);

        finishButton = findViewById(R.id.add_finish_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.get().addNewTrip();

                Intent i = new Intent(AddTagsActivity.this, TripsActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("EXIT", true);
                startActivity(i);
            }
        });

        final RowLayout tagsLayout = findViewById(R.id.add_tags_list);
        EditText editText = findViewById(R.id.add_tags_input);
        editText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView tagInput, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    View tagView = LayoutInflater.from(AddTagsActivity.this).inflate(R.layout.tag_view, tagsLayout, false);

                    String tag = tagInput.getText().toString();
                    if (!tag.isEmpty()) {
                        Data.get().newTrip.addTag(tag);

                        TextView tagViewText = (TextView) AddTagsActivity.this.getLayoutInflater().inflate(R.layout.tag_small_view, null);
                        tagViewText.setText('#' + tag);

                        tagsLayout.addView(tagView);

                        tagInput.setText("");

                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void updateData() {

    }

}
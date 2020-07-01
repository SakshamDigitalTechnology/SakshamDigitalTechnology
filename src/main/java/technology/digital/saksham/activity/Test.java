package technology.digital.saksham.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import technology.digital.saksham.R;

public class Test extends AppCompatActivity {
    RecyclerView recyclerView;
    Integer[] image = {R.drawable.ic_back, R.drawable.ic_learning, R.drawable.ic_java, R.drawable.ic_python};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

    }
}

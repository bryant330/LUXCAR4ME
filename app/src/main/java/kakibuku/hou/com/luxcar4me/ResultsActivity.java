package kakibuku.hou.com.luxcar4me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kakibuku.hou.com.luxcar4me.utils.ContentView;
import kakibuku.hou.com.luxcar4me.utils.DynamicRecyclerViewAdapter;

public class ResultsActivity extends AppCompatActivity {

    // Views
    @Bind(R.id.recyclerView) RecyclerView recyclerView;
    // RecyclerView
    LinearLayoutManager linearLayoutManager;
    DynamicRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // Adapter
        adapter = new DynamicRecyclerViewAdapter(recyclerView);
        adapter.register(CarListingContent.class, new CarListingContent.ViewHolder(this));

        // TODO: replace with actual data from server
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
        adapter.put(new CarListingContent());
    }

    public static class CarListingContent {

        public static class ViewHolder extends ContentView<CarListingContent> {

            final Activity activity;

            @Bind(R.id.rating_layout)
            LinearLayout ratingLayout;


            public ViewHolder(Activity activity) {
                super(R.layout.car_list);
                this.activity = activity;
            }

            @Override
            public ViewHolder instantiate() {
                return new ViewHolder(activity);
            }

            @OnClick(R.id.bookButton)
            void onClickBook() {
                Intent intent = new Intent(activity, CheckoutActivity.class);
                activity.startActivity(intent);
            }

            @OnClick(R.id.carCardview)
            void onClickCar() {
                if (ratingLayout.getVisibility() == View.VISIBLE)
                    ratingLayout.setVisibility(View.GONE);
                else
                    ratingLayout.setVisibility(View.VISIBLE);
            }
        }

    }


}

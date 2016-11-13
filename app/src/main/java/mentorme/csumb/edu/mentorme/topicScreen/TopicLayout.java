package mentorme.csumb.edu.mentorme.topicScreen;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mentorme.csumb.edu.mentorme.R;
import mentorme.csumb.edu.mentorme.data.model.topics.Topics;
import mentorme.csumb.edu.mentorme.homeScreen.homeLayoutAdapter.SubjectsAdapter;
import mentorme.csumb.edu.mentorme.topicScreen.topicsLayoutAdapter.TopicsAdapter;
import rx.Subscriber;

/**
 * Handles user Interface for Topics.
 */
public class TopicLayout extends Subscriber<Topics> {

    private final String TAG = "TopicLayout";

    private AppCompatActivity mActivity;
    private TopicLayoutListener mListener;

    @BindView(R.id.drawer_layout) DrawerLayout mDrawer;
    @BindView(R.id.nav_view) NavigationView mNavigationView;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.toolbar_layout) Toolbar mToolbar;
    @BindView(R.id.toolbar_title) TextView mToolbarTitle;

    TopicLayout(AppCompatActivity activity, TopicLayoutListener listener) {
        mActivity = activity;
        mListener = listener;

        mActivity.setContentView(R.layout.app_main_layout);

        ButterKnife.bind(this, mActivity);

        mToolbarTitle.setText("Topics");
        mActivity.setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                mActivity, mDrawer, mToolbar, R.string.open, R.string.close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @OnClick(R.id.nav_view)
    public void onNavigationMenuClick(){

        mListener.onNavigationMenuClick();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, e.getMessage());
    }

    @Override
    public void onNext(Topics topics) {
        TopicsAdapter adapter = new TopicsAdapter(
                mActivity.getApplicationContext(),
                topics.getTopics());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity.getApplicationContext()));
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * Listener for {@link TopicLayout}
     */
    public interface TopicLayoutListener {
        void onNavigationMenuClick();
    }
}

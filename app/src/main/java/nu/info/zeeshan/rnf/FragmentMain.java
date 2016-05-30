package nu.info.zeeshan.rnf;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nu.info.zeeshan.rnf.adapters.ItemAdapter;
import nu.info.zeeshan.rnf.util.ActionClickListener;
import nu.info.zeeshan.rnf.model.Item;
import nu.info.zeeshan.rnf.util.MySwipeRefreshLayout;
import nu.info.zeeshan.rnf.util.Util;

/**
 *FragmentMain
 * Created by Zeeshan Khan on 10/28/2015.
 */
public abstract class FragmentMain extends Fragment implements SwipeRefreshLayout
        .OnRefreshListener {
    public static String TAG = FragmentMain.class.getSimpleName();
    protected MySwipeRefreshLayout swipeRefreshLayout;
    protected ItemAdapter itemAdapter;
    private ActionClickListener actionClickListener = new ActionClickListener() {
        @Override
        public void onLikeClick(long itemId) {

        }

        @Override
        public void onFullStoryClick(String url) {
            Intent intent = new Intent(getActivity().getApplicationContext(), FullStoryActivity
                    .class);
            Bundle bundle = new Bundle();
            bundle.putString("url", url);
            intent.putExtras(bundle);
            startActivity(intent);
        }

        @Override
        public void onShareClick(Item item) {

        }
    };

    public FragmentMain() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView itemList = (RecyclerView) rootView.findViewById(R.id.item_list);
        itemList.setLayoutManager(new LinearLayoutManager(getContext()));
        swipeRefreshLayout = (MySwipeRefreshLayout) rootView.findViewById(R.id
                .swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        itemAdapter = new ItemAdapter(new ArrayList<Item>(), getContext(), actionClickListener);
        itemList.setAdapter(itemAdapter);
        return rootView;
    }

    /**
     * called on refresh action performed by SwipeRefreshLayout
     */
    @Override
    public void onRefresh() {
        String msg = null;
        ConnectivityManager cm = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null && ni.isConnected()) {
            startFetchingFeed();
        } else {
            msg = getString(R.string.toast_no_internet);
            stopRefresh();
        }
        if (msg != null)
            showMsg(msg);
    }

    public void stopRefresh() {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        } else
            Util.log(TAG, "refreshlayout is null");
    }

    protected void showMsg(String msg) {
        Snackbar.make(swipeRefreshLayout, msg, Snackbar.LENGTH_SHORT).show();
    }

    public abstract void startFetchingFeed();
}

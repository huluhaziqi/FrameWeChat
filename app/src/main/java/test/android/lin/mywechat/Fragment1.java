package test.android.lin.mywechat;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by linxiaobin on 2015/9/10.
 */
public class Fragment1 extends Fragment {

    OnBackListener backListener;

    public interface OnBackListener {
        public void backEvent();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            backListener = (OnBackListener) activity;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View parentView = inflater.inflate(R.layout.fragment1, container, false);
        Button btBack = (Button) parentView.findViewById(R.id.btBack);
        Button btOther = (Button) parentView.findViewById(R.id.btOther);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backListener != null)
                    backListener.backEvent();
            }
        });
        btOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OtherActivity.class);
                startActivity(intent);
            }
        });
        return parentView;

    }
}

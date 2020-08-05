package com.example.come_by;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;


public class Frag1 extends Fragment {

    private View view;
    private ViewPager viewPager;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500; //처음 대기 시간
    final long PERIOD_MS = 3000; // 반복 시간, 즉 몇 초 마다 count+1이 되는지

    //onCreate가 실행된 이후 onCreateView가 실행된다.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag1, container, false);//container안에 R.layout.frag1이 삽입된다.

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new ImageAdapter(getActivity()));

        final Handler handler = new Handler();
        //runnable은 하나의 인터페이스로 규약이다. 하나라도 실행되지 않으면 안된다.
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if(currentPage == 3) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
        //schedule(TimerTask task, long delay, long period)
        //일정 시간(delay)이 지난 후에 일정 간격(period)으로 지정한 작업(task)을 수행한다.schedule(TimerTask task, long delay, long period)
        //runnable 객체를 보낼 때는 handler.post를 이용한다.


        return view;

    }

}

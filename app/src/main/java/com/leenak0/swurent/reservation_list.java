package com.leenak0.swurent;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class reservation_list extends BaseAdapter {
    LayoutInflater inflater = null;
    private ArrayList<ListVO> m_oData = null;
    private int nListCnt = 0;

    public reservation_list(ArrayList<ListVO> _oData) {
        m_oData = _oData;
        nListCnt = m_oData.size();

    }

    @Override
    public int getCount() {
        Log.i("TAG", "getCount");
        return nListCnt;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //postion = ListView의 위치      /   첫번째면 position = 0

        if (convertView == null) {
            final Context context = parent.getContext();
            if (inflater == null) {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.activity_reservation_list, parent, false);
        }

        Button button_info_classroom = (Button) convertView.findViewById(R.id.btn_info_classroom);
        ImageView image = (ImageView) convertView.findViewById(R.id.img);
        TextView title = (TextView) convertView.findViewById(R.id.texttitle);
        TextView limitnum = (TextView) convertView.findViewById(R.id.textlimitnum);
        Button button9 = (Button) convertView.findViewById(R.id.btn_9);
        Button button10 = (Button) convertView.findViewById(R.id.btn_10);
        Button button11 = (Button) convertView.findViewById(R.id.btn_11);
        Button button12 = (Button) convertView.findViewById(R.id.btn_12);
        Button button13 = (Button) convertView.findViewById(R.id.btn_13);
        Button button14 = (Button) convertView.findViewById(R.id.btn_14);


        //ListVO listViewItem = ListVO.get(position);

        image.setImageResource(R.drawable.classroom);
        title.setText(m_oData.get(position).strTitle);
        limitnum.setText(m_oData.get(position).strLimitnum);
        button9.setOnClickListener(m_oData.get(position).onClickListener);

        convertView.setTag("" + position);
        return convertView;


        // 아이템 내 각 위젯에 데이터 반영
        /*
        image.setImageDrawable(listViewItem.getImg());
        title.setText(listViewItem.getTitle());
        Context.setText(listViewItem.getContext()); */

        /*
        //이거는 어댑터에서 해보려고 하는데 안되는 코드
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListViewAdapter.this, reservation.class);
            }
        });

        //이게 그냥 액티비티에서 할 때는 되던 코드
        btn_building_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, choice_floor.class);
                startActivity(intent);
            }
        });
        */


        /*
        button9.setOnClickListener((View.OnClickListener)context);
        button9.setTag("asf");
        //OptionButton.setTag(welarmDTOMap.get("welarmNo").toString());
        */

        //button9.setTag(position);
        //button9.setOnClickListener((View.OnClickListener) this);


        //팝업창 띄우는 버튼 생성한 건데.. 오류나네 ㅠㅠ
        /*
        button_info_classroom.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_info_classroom;
                        new AlertDialog.Builder(choice_classroom)
                                .setTitle("알람 팝업")
                                .setMessage("팝업 창의 내용입니다.\n\n Test!")
                                .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int something) {

                                    }
                                })
                                .show(); //팝업창 보여줌
                        break;
                }

            }
        });
        */


        //여기부터는 일단 구현을 못해서 누르면 토스트 메시지 뜨게만 해놨어.

        /*
        button10.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, (pos + 1) + "button.", Toast.LENGTH_SHORT).show();
            }
        });

        button11.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, (pos + 1) + "button.", Toast.LENGTH_SHORT).show();
            }
        });

        button12.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, (pos + 1) + "button.", Toast.LENGTH_SHORT).show();
            }
        });

        button13.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, (pos + 1) + "button.", Toast.LENGTH_SHORT).show();
            }
        });

        button14.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, (pos + 1) + "button.", Toast.LENGTH_SHORT).show();
            }
        });







        //리스트뷰 클릭 이벤트
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, (pos + 1) + "번째 리스트가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }

    public void addVO(Drawable icon, String title, String desc) {
        ListVO item = new ListVO();

        item.setImg(icon);
        item.setTitle(title);
        item.setContext(desc);

        listVO.add(item);
    }
    */

    }
}

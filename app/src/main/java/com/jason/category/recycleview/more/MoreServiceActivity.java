package com.jason.category.recycleview.more;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jason.category.recycleview.R;
import com.jason.category.recycleview.adapter.RecycleAdapter;
import com.jason.category.recycleview.adapter.ViewHolder;
import com.jason.category.recycleview.bean.ColumnItem;
import com.jason.category.recycleview.bean.MoreObj;
import com.jason.category.recycleview.bean.ServiceItem;
import com.jason.category.recycleview.bean.Services;
import com.jason.category.recycleview.utils.JsonHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * 更多服务
 */
public class MoreServiceActivity extends Activity {

    private final String TAG = MoreServiceActivity.class.getSimpleName();

    RecyclerView leftRecycle;
    RecyclerView rightRecycle;

    RecycleAdapter leftAdapter;
    RecycleAdapter rightAdapter;
    int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_service);
        initViews();
        requestData();
    }

    private void initViews() {
        leftRecycle = (RecyclerView) findViewById(R.id.main_left_recycle);
        rightRecycle = (RecyclerView) findViewById(R.id.main_right_recycle);
        leftRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rightRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    private void requestData(){
        String testData = "{\"columnList\":[{\"columnId\":1,\"columnName\":\"就业创业\"},{\"columnId\":2,\"columnName\":\"生活周边\"},{\"columnId\":4,\"columnName\":\"医疗健康\"},{\"columnId\":5,\"columnName\":\"网上办事\"},{\"columnId\":6,\"columnName\":\"统一账单\"},{\"columnId\":7,\"columnName\":\"教育生涯\"},{\"columnId\":8,\"columnName\":\"交通出行\"},{\"columnId\":9,\"columnName\":\"游在常熟\"},{\"columnId\":10,\"columnName\":\"特色服务\"},{\"columnId\":11,\"columnName\":\"市民卡\"}],\"serviceListAll\":[{\"columnId\":6,\"columnName\":\"统一账单\",\"isRecommend\":\"1\",\"level\":\"0\",\"serviceId\":0,\"serviceName\":\"违章查询\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/tyzd/wzcx.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneBill/traffic/traffic.html\",\"siteId\":\"320581\"},{\"columnId\":6,\"columnName\":\"统一账单\",\"isRecommend\":\"1\",\"level\":\"2\",\"serviceId\":1,\"serviceName\":\"公积金账单\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/tyzd/ggjzd.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneBill/accumulation_fund/index.html\",\"siteId\":\"320581\"},{\"columnId\":8,\"columnName\":\"交通出行\",\"isRecommend\":\"1\",\"level\":\"0\",\"serviceId\":2,\"serviceName\":\"公交查询\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/zncx/gjcx.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneTirp/bus/bus.html\",\"siteId\":\"320581\"},{\"columnId\":6,\"columnName\":\"统一账单\",\"isRecommend\":\"1\",\"level\":\"0\",\"serviceId\":3,\"serviceName\":\"驾驶员记分\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/tyzd/jsyjfcx.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneBill/driver_score_cs/index.html\",\"siteId\":\"320581\"},{\"columnId\":6,\"columnName\":\"统一账单\",\"isRecommend\":\"1\",\"level\":\"2\",\"serviceId\":5,\"serviceName\":\"医保账单\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/tyzd/ybzd.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneBill/social_security/security_bill.html\",\"siteId\":\"320581\"},{\"columnId\":6,\"columnName\":\"统一账单\",\"isRecommend\":\"1\",\"level\":\"2\",\"serviceId\":7,\"serviceName\":\"社保账单\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/tyzd/sbzd.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneBill/socialBill/index.html\",\"siteId\":\"320581\"},{\"columnId\":5,\"columnName\":\"办事办证\",\"isRecommend\":\"1\",\"level\":\"1\",\"serviceId\":8,\"serviceName\":\"网上办事\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/bsbz/bszn.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneOnlinework/online_government/index.html#main\",\"siteId\":\"320581\"},{\"columnId\":4,\"columnName\":\"医疗健康\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":9,\"serviceName\":\"养生保健\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/yljk/ysbj.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneAppcms/keep_health/ysbj.html\",\"siteId\":\"320581\"},{\"columnId\":4,\"columnName\":\"医疗健康\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":10,\"serviceName\":\"用药知识\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/yljk/yyzs.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneAppcms/medicate_health/yyzs.html\",\"siteId\":\"320581\"},{\"columnId\":2,\"columnName\":\"生活周边\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":11,\"serviceName\":\"快递查询\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/shzb/kdcx.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneSpecial/kuaidi/kuaidi.html\",\"siteId\":\"320581\"},{\"columnId\":9,\"columnName\":\"游在常熟\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":12,\"serviceName\":\"景点介绍\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/yzcs/jdjs.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneTravel/attractions/index.html\",\"siteId\":\"320581\"},{\"columnId\":2,\"columnName\":\"生活周边\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":14,\"serviceName\":\"家政服务\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/shzb/jzfw.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneLife/houseCare/index.html\",\"siteId\":\"320581\"},{\"columnId\":2,\"columnName\":\"生活周边\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":15,\"serviceName\":\"餐饮服务\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/shzb/cyfw.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneLife/cateringServices/index.html\",\"siteId\":\"320581\"},{\"columnId\":2,\"columnName\":\"生活周边\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":16,\"serviceName\":\"家庭服务\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/shzb/jtfw.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneLife/homeService/index.html\",\"siteId\":\"320581\"},{\"columnId\":2,\"columnName\":\"生活周边\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":17,\"serviceName\":\"文化场馆\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/shzb/whcg.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneLife/culture/index.html\",\"siteId\":\"320581\"},{\"columnId\":9,\"columnName\":\"游在常熟\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":19,\"serviceName\":\"旅游年卡\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/yzcs/lynk.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneTravel/travel_card/index.html\",\"siteId\":\"320581\"},{\"columnId\":2,\"columnName\":\"生活周边\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":20,\"serviceName\":\"中介服务\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/shzb/zjfw.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneLife/agencyService/index.html\",\"siteId\":\"320581\"},{\"columnId\":7,\"columnName\":\"教育生涯\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":23,\"serviceName\":\"教育资源\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/jysy/jyzy.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneEduinfo/education/index.html\",\"siteId\":\"320581\"},{\"columnId\":2,\"columnName\":\"生活周边\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":25,\"serviceName\":\"住房服务\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/shzb/zffw.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneLife/house_service/index.html\",\"siteId\":\"320581\"},{\"columnId\":7,\"columnName\":\"教育生涯\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":26,\"serviceName\":\"心理辅导\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/jysy/xlfd.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneAppcms/mental_health/xlfd.html\",\"siteId\":\"320581\"},{\"columnId\":1,\"columnName\":\"就业创业\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":27,\"serviceName\":\"创业指南\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/jycy/cyzn.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneAppcms/busness_guide/cyzn.html\",\"siteId\":\"320581\"},{\"columnId\":1,\"columnName\":\"就业创业\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":28,\"serviceName\":\"失业保险\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/jycy/sybx.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneAppcms/unemployed_insurance/sybx.html\",\"siteId\":\"320581\"},{\"columnId\":5,\"columnName\":\"办事办证\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":29,\"serviceName\":\"政策公告\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/bsbz/zcgg.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneAppcms/announcement/index.html\",\"siteId\":\"320581\"},{\"columnId\":10,\"columnName\":\"特色服务\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":31,\"serviceName\":\"同名查询\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/shzb/tmcx.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneSpecial/synonym/synonym.html\",\"siteId\":\"320581\"},{\"columnId\":1,\"columnName\":\"就业创业\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":32,\"serviceName\":\"就业指导\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/jycy/jyzd.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneAppcms/work_guide/jyzd.html\",\"siteId\":\"320581\"},{\"columnId\":5,\"columnName\":\"办事办证\",\"isRecommend\":\"0\",\"level\":\"2\",\"serviceId\":34,\"serviceName\":\"个人征信\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/tyzd/grzx.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneOnlinework/cerdit/index.html#main\",\"siteId\":\"320581\"},{\"columnId\":11,\"columnName\":\"市民卡\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":35,\"serviceName\":\"市民卡密码修改\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/smk/smkmmxg.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneSmk/smkPasswordChange/smkPasswordChange.html\",\"siteId\":\"320581\"},{\"columnId\":11,\"columnName\":\"市民卡\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":36,\"serviceName\":\"市民卡挂失\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/smk/smkgs.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneSmk/smkLoss/smkLoss.html\",\"siteId\":\"320581\"},{\"columnId\":4,\"columnName\":\"医疗健康\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":37,\"serviceName\":\"产检计划\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/yljk/cjjh.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneMedicalCare/checkPlan/checkPlan.html\",\"siteId\":\"320581\"},{\"columnId\":4,\"columnName\":\"医疗健康\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":38,\"serviceName\":\"预防接种\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/yljk/yfjz.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneMedicalCare/Vaccination/Vaccination.html\",\"siteId\":\"320581\"},{\"columnId\":8,\"columnName\":\"交通出行\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":39,\"serviceName\":\"停车场\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/zncx/tcc.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneTirp/parkinglot/park_list.html\",\"siteId\":\"320581\"},{\"columnId\":8,\"columnName\":\"交通出行\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":40,\"serviceName\":\"自行车站点\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/zncx/zxczd.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneTirp/bike/list_bike.html\",\"siteId\":\"320581\"},{\"columnId\":10,\"columnName\":\"特色服务\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":41,\"serviceName\":\"肉菜溯源\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/tsfw/rcsy.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneSpecial/rezen_source/index.html#main\",\"siteId\":\"320581\"},{\"columnId\":2,\"columnName\":\"生活周边\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":42,\"serviceName\":\"智慧驾校\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/shzb/zhjx.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneLife/drivingRegres/index.html\",\"siteId\":\"320581\"},{\"columnId\":4,\"columnName\":\"医疗健康\",\"isRecommend\":\"0\",\"level\":\"1\",\"serviceId\":43,\"serviceName\":\"预约挂号\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/yljk/yygh.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneMedicalCare/hospital_regres/index.html\",\"siteId\":\"320581\"},{\"columnId\":2,\"columnName\":\"生活周边\",\"isRecommend\":\"0\",\"level\":\"0\",\"serviceId\":44,\"serviceName\":\"养老服务\",\"servicePicUrl\":\"http://sm.cszhcs.cn/image/get/mobile/shzb/ylfw.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneLife/elderlyCare/index.html\",\"siteId\":\"320581\"},{\"columnId\":7,\"columnName\":\"教育生涯\",\"isRecommend\":\"0\",\"level\":\"1\",\"serviceId\":46,\"serviceName\":\"教育缴费\",\"servicePicUrl\":\"http://www.cszhcs.cn/image/get/system/default/9a6bfb4c8f73e1f8e094eb660a3810ab.png\",\"serviceUrl\":\"http://sm.cszhcs.cn/cs_phoneEduinfo/educationPayM/index.html\",\"siteId\":\"320581\"}]}";
        try {
            List<ColumnItem> leftList;
            List<Services> rightList = new ArrayList<>();
            MoreObj more = JsonHelper.parseObject(testData, MoreObj.class);
            if (null != more.columnList && more.columnList.size() > 0) {
                for (int i = 0; i < more.columnList.size(); i++) {
                    ColumnItem one = more.columnList.get(i);
                    Services services = new Services();
                    List<ServiceItem> serviceList = new ArrayList<ServiceItem>();
                    for (ServiceItem it : more.serviceListAll) {
                        if (it.columnId.equals(one.getColumnId())) {
                            serviceList.add(it);
                        }
                    }
                    if (serviceList.size() == 0) {

                    } else {
                        services.itemList = serviceList;
                        services.columnName = one.getColumnName();
                        rightList.add(services);
                    }
                }
                leftList = more.columnList;
                fillData(leftList, rightList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void fillData(List<ColumnItem> leftList, List<Services> rightList) {
        leftAdapter = new RecycleAdapter(this, R.layout.item_left, leftList);
        leftRecycle.setAdapter(leftAdapter);
        rightAdapter = new RecycleAdapter(this, R.layout.item_right, rightList);
        rightRecycle.setAdapter(rightAdapter);
        leftAdapter.setCallBack(new RecycleAdapter.CallBack() {
            @Override
            public <T> void convert(ViewHolder holder, T bean, int position) {
                LinearLayout layout = (LinearLayout) holder.getView(R.id.item_main_left_layout);
                TextView type = (TextView) holder.getView(R.id.item_main_left_type);
                type.setText(((ColumnItem)bean).getColumnName());
                if (position == currentPosition) {
                    layout.setBackgroundColor(0xffffffff);
                } else {
                    layout.setBackgroundColor(0xffeeeeee);
                }
            }
        });

        leftAdapter.setOnItemClickListner(new RecycleAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Log.i("leftAdapter", "scrollToPositionWithOffset-->" + position);
                currentPosition = position;
                LinearLayoutManager llm = ((LinearLayoutManager) rightRecycle.getLayoutManager());
                llm.scrollToPositionWithOffset(position, 0);
                leftAdapter.notifyDataSetChanged();
            }
        });


        rightAdapter.setCallBack(new RecycleAdapter.CallBack() {
            @Override
            public <T> void convert(ViewHolder holder, T bean, int position) {
                holder.setText(R.id.item_main_right_type, ((Services)bean).columnName);
                RecyclerView detailsRecycle = (RecyclerView) holder.getView(R.id.item_main_right_recycle);
                updateDetailsRecycle(detailsRecycle, position);
            }
        });


        rightRecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager rightManager = (LinearLayoutManager) rightRecycle.getLayoutManager();
                LinearLayoutManager leftManager = ((LinearLayoutManager) leftRecycle.getLayoutManager());

                /**
                 * 获取第一个item为第几个position
                 */
                currentPosition = rightManager.findFirstVisibleItemPosition();


                /**
                 * 这地方需要进行判断，如果右边的Recycle在移动的时候，左边的RecycleView也是需要进行移动的
                 * 左边的recycleview有可能会不可见，这时候，我们必须去判断一下，左边最后的一个item是不是
                 * 小于右边滑动的位置，或左边第一个item是不是大于右边滑动的位置
                 */
                if (leftManager.findFirstVisibleItemPosition() > currentPosition) {
                    leftManager.scrollToPositionWithOffset(currentPosition, 0);
                } else if (leftManager.findLastVisibleItemPosition() < currentPosition) {
                    leftManager.scrollToPositionWithOffset(currentPosition, 0);
                }

                /**
                 * 判断右边是否滑动到最后一个item，是的话，也将左边移动到最后一个item
                 * canScrollVertically(1)表示是否能向上滚动，false表示已经滚动到底部
                 */
                if (!rightRecycle.canScrollVertically(1)) {
                    currentPosition = rightAdapter.getItemCount() - 1;

                    Log.i("tag", currentPosition + "-------");
                }
                leftAdapter.notifyDataSetChanged();
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    /**
     * 更新详情列表
     *
     * @param detailsRecycle
     */
    public void updateDetailsRecycle(RecyclerView detailsRecycle,int position) {
        List<Services> services = (List<Services>) rightAdapter.getData();
        final RecycleAdapter detailsAdapter = new RecycleAdapter(this, R.layout.item_details, services.get(position).itemList);
        detailsRecycle.setAdapter(detailsAdapter);
        detailsRecycle.setLayoutManager(new GridLayoutManager(this, 3));
        detailsAdapter.setCallBack(new RecycleAdapter.CallBack() {
            @Override
            public <T> void convert(ViewHolder holder, T bean, int position) {
                ServiceItem serviceItem = (ServiceItem) bean;
                TextView name = (TextView) holder.getView(R.id.tvName);
                ImageView ivIcon = (ImageView) holder.getView(R.id.ivIcon);
                name.setText(serviceItem.serviceName);
                Picasso.with(MoreServiceActivity.this).load(serviceItem.servicePicUrl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).config(Bitmap.Config.RGB_565).into(ivIcon);
//                Glide.with(MoreServiceActivity.this).load(serviceItem.servicePicUrl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(ivIcon);
            }
        });
        detailsAdapter.setOnItemClickListner(new RecycleAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                ServiceItem serviceItem = (ServiceItem) detailsAdapter.getData().get(position);
                toCordoVaWeb(serviceItem);
            }
        });
    }

    private void toCordoVaWeb(ServiceItem one) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(one.serviceUrl));
        startActivity(intent);
    }
}

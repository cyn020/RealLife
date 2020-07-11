package com.local.project.pages.activity;

import android.os.Bundle;

import com.local.project.base.BaseActivity;
import com.local.project.base.BaseApplication;
import com.local.project.data.DiaryBean;
import com.local.project.data.DiaryBeanDao;
import com.local.project.databinding.ActivityDiaryDetailBinding;
import com.local.project.util.VoiceManager;

public class DiaryDetailActivity extends BaseActivity<ActivityDiaryDetailBinding> {

    private VoiceManager manager;

    @Override
    public void initOnViewClick() {

    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        actionBar.setDisplayHomeAsUpEnabled(true);
        manager = VoiceManager.getInstance(context);
        DiaryBeanDao diaryDao = BaseApplication.getDaoSession().getDiaryBeanDao();
        long id = getIntent().getLongExtra("id",0);
        DiaryBean diaryBean = diaryDao.queryBuilder()
                .where(DiaryBeanDao.Properties.Id.eq(id))
                .build().unique();
        if (diaryBean !=null){
            binding.diaryCreateTime.setText(diaryBean.getYear()+"-"+diaryBean.getMonth()+"-"+diaryBean.getDay());
            binding.diaryCreateTitle.setText(diaryBean.getTitle());
            binding.diaryCreateContent.setText(diaryBean.getContent());
            binding.diaryCreateType.setImageResource(diaryBean.getType());
            manager.startPlay(diaryBean.getMusic());
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.stopPlay();
    }


}

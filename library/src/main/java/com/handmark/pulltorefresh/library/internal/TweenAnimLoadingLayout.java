package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.R;

/**
 * File description:
 *
 * @author 李辉
 * @date 2017/8/2 17:29.
 */

public class TweenAnimLoadingLayout extends LoadingLayout {

    private final AnimationDrawable animationDrawable;

    public TweenAnimLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);
        //初始化
        mHeaderImage.setImageResource(R.drawable.anim_refresh);
        animationDrawable = (AnimationDrawable) mHeaderImage.getDrawable();
    }

    //默认图片
    @Override
    protected int getDefaultDrawableResId() {
        return R.drawable.indicator_arrow;
    }

    @Override
    protected void onLoadingDrawableSet(Drawable imageDrawable) {

    }

    @Override
    protected void onPullImpl(float scaleOfLayout) {

    }

    //下拉刷新
    @Override
    protected void pullToRefreshImpl() {

    }

    //正在刷新时
    @Override
    protected void refreshingImpl() {
        //播放帧动画
        animationDrawable.start();
    }

    //释放以刷新
    @Override
    protected void releaseToRefreshImpl() {

    }

    //重置刷新
    @Override
    protected void resetImpl() {
        mHeaderImage.setVisibility(View.VISIBLE);
        mHeaderImage.clearAnimation();
    }


}

package com.project.jebus.appsolar.ui.coreJebus;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;


/**
 * Created by jebus on 14/02/2015.
 */
public class AnimationJebus {

    private static OnAnimationJebusListener onAnimationJebusListener;
    private static ObjectAnimator objectAnimator;

    private boolean isRebound = false;

    public AnimationJebus(OnAnimationJebusListener onAnimationJebusListener){
        this.onAnimationJebusListener = onAnimationJebusListener;
    }

    public static void setAlphaAnimation(final View view, float origin, float end, int duration, final int index) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", origin, end);
        alpha.setInterpolator(new AccelerateInterpolator());
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                onAnimationJebusListener.onAnimationStart(index, view);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                onAnimationJebusListener.onAnimationEnd(index, view);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                onAnimationJebusListener.onAnimationCancel(index);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                onAnimationJebusListener.onAnimationRepeat(index);
            }
        });
        alpha.setDuration(duration);
        //alpha.setStartDelay(800);
        alpha.start();

        objectAnimator = alpha;
    }

    public void setBackgroundColorAnimation(final View view, int origin, int end, int duration, final int index) {
        ObjectAnimator alpha = ObjectAnimator.ofInt(view, "backgroundColor", origin, end);
        alpha.setInterpolator(new AccelerateInterpolator());
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                onAnimationJebusListener.onAnimationStart(index, view);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                onAnimationJebusListener.onAnimationEnd(index, view);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                onAnimationJebusListener.onAnimationCancel(index);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                onAnimationJebusListener.onAnimationRepeat(index);
            }
        });
        alpha.setDuration(duration);
        //alpha.setStartDelay(800);
        alpha.start();
        objectAnimator = alpha;
    }

    public void setScaleYAnimation(final ImageView view, float scaleOrigin, float scaleEnd, int duration) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "scaleY", scaleOrigin, scaleEnd);
        alpha.setInterpolator(new AccelerateInterpolator());
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        alpha.setDuration(duration);
        alpha.start();
        objectAnimator = alpha;
    }

    public void setRotationAnimation(final View view, float angleOrigin, float angleEnd, int duration) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "rotation", angleOrigin, angleEnd);
        alpha.setInterpolator(new AccelerateInterpolator());
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //if(view != null)view.setImageResource(resource);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        alpha.setDuration(duration);
        alpha.start();
        objectAnimator = alpha;
    }

    public void setTranslationAnimationX(final View view, float star, float end, long duration, final int index) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "translationX", star, end);
        alpha.setInterpolator(new AccelerateInterpolator());
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (!isRebound) {
                    onAnimationJebusListener.onAnimationStart(index, view);
                } else {

                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!isRebound) {
                    onAnimationJebusListener.onAnimationEnd(index, view);
                } else {
                    isRebound = false;
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                if (!isRebound) {
                    onAnimationJebusListener.onAnimationCancel(index);
                } else {

                }
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                if (!isRebound) {
                    onAnimationJebusListener.onAnimationRepeat(index);
                } else {

                }
            }
        });
        alpha.setDuration(duration);
        alpha.start();
        objectAnimator = alpha;
    }

    public void setReboundAnimationX(final View view, float star, final float end, long duration, final int index) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "translationX", star, end);
        alpha.setInterpolator(new AccelerateInterpolator());
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isRebound = true;
                setTranslationAnimationX(view, end, 0, 200, 0);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        alpha.setDuration(duration);
        alpha.start();
        objectAnimator = alpha;
    }

    public void setReboundAnimationY(final View view, float star, final float end, long duration, final int index) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "translationY", star, end);
        alpha.setInterpolator(new AccelerateInterpolator());
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isRebound = true;
                setTranslationAnimationY(view, end, 0, 200, 0, 0);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        alpha.setDuration(duration);
        alpha.start();
        objectAnimator = alpha;
    }

    public void setTranslationAnimationY(final View view, float star, float end, long duration, long delay, final int index) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "translationY", star, end);
        alpha.setInterpolator(new AccelerateInterpolator());
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (!isRebound) {
                    onAnimationJebusListener.onAnimationStart(index, view);
                } else {

                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!isRebound) {
                    onAnimationJebusListener.onAnimationEnd(index, view);
                } else {
                    isRebound = false;
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                if (!isRebound) {
                    onAnimationJebusListener.onAnimationCancel(index);
                } else {

                }
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                if (!isRebound) {
                    onAnimationJebusListener.onAnimationRepeat(index);
                } else {

                }
            }
        });
        alpha.setDuration(duration);
        alpha.setStartDelay(delay);
        alpha.start();
        objectAnimator = alpha;
    }

    public void setScaleYAnimation(final View view, float origin, float end, int duration, int delay, final int index) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "scaleY", origin, end);
        alpha.setInterpolator(new AccelerateInterpolator());
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                onAnimationJebusListener.onAnimationStart(index, view);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                onAnimationJebusListener.onAnimationEnd(index, view);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                onAnimationJebusListener.onAnimationCancel(index);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                onAnimationJebusListener.onAnimationRepeat(index);
            }
        });
        alpha.setDuration(duration);
        alpha.setStartDelay(delay);
        alpha.setRepeatMode(ValueAnimator.REVERSE);
        alpha.setRepeatCount(999999999);
        alpha.start();
        objectAnimator = alpha;
    }

    public void setScaleXAnimation(final View view, float origin, float end, int duration, int delay, final int index) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "scaleX", origin, end);
        alpha.setInterpolator(new AccelerateInterpolator());
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                onAnimationJebusListener.onAnimationStart(index, view);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                onAnimationJebusListener.onAnimationEnd(index, view);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                onAnimationJebusListener.onAnimationCancel(index);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                onAnimationJebusListener.onAnimationRepeat(index);
            }
        });
        alpha.setDuration(duration);
        alpha.setStartDelay(delay);
        alpha.setRepeatMode(ValueAnimator.REVERSE);
        alpha.setRepeatCount(999999999);
        alpha.start();
        objectAnimator = alpha;
    }

    public void cancelAnimationJebus(){
        objectAnimator.cancel();
        objectAnimator.setAutoCancel(true);
    }

    public interface OnAnimationJebusListener {

        public void onAnimationStart(int index, View view);
        public void onAnimationEnd(int index, View view);
        public void onAnimationCancel(int index);
        public void onAnimationRepeat(int index);

    }

}

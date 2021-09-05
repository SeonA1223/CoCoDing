# Animation

animation을 정의 ⇒ 시간 경과에 따라 객체 속성 변경 가능

- 재생 시간: 애니메이션 재생 시간을 지정할 수 있습니다. 기본 길이는 300ms입니다.
- 시간 보간: 속성의 값이 애니메이션의 현재 경과 시간 함수로 계산되는 방식을 지정할 수 있습니다.
- 반복 횟수 및 동작: 재생 시간이 끝나고 애니메이션 반복 횟수에 도달하면 애니메이션 반복 여부를 지정할 수 있습니다. 애니메이션을 역방향으로 재생할지도 지정할 수 있습니다. 역방향으로 설정하면 반복 재생 횟수에 도달할 때까지 애니메이션이 앞뒤로 반복 재생됩니다.
- 애니메이터 조합: 애니메이션을 함께 또는 순차적으로 재생하거나 지정된 지연 시간 후에 재생하는 논리 조합으로 그룹화할 수 있습니다.

ValueAnimator : 속성 애니메이션의 주요 타이밍 엔진, 세세한건 다 여기서 한대

ObjectAnimator : ValueAnimotor의 서브클래스 , 기본적인건 이걸 사용

AnimatorSet : 애니메이션이 서로 관련되어 실행되도록 그룹화하는 메커니즘

보간 사용

LinearInterpolator	변경 속도가 일정한 보간

### ObjectAnimator

몇 초동안

```java
alpha.setDuration(1000); - default(300)
```

1. motion

   왼쪽방향 " "도 회전

   ```java
   ObjectAnimator rotation = ObjectAnimator.offFloat(imageview, "rotation", -360)
   ```

   오른쪽방향 ""도 회전

   ```java
   ObjectAnimator rotation = ObjectAnimator.offFloat(imageview, "rotation", 360)
   ```

   X,Y좌표로 바꾸기(10만큼 바꾸기면 10만큼 이동)

   ```java
   ObjectAnimator translation = ObjectAnimator.ofFloat(imageview, "translationY", 0, 500);
   ```

   X,Y좌표로 정하기(10만큼 정하기면 10으로 정해짐)

   ```java
   ObjectAnimator translation = ObjectAnimator.ofFloat(imageview, "translationY", 0, 500);
   (이전 위치, 나중 위치 값을 같게 해주기)
   
   or
   
   imageView.setX(100);
   imageView.setY(100);
   ```

2. shape

   보이기

   ```java
   ObjectAnimator translation = ObjectAnimator.ofFloat(imageview, "alpha", 1);
   ```

   숨기기

   ```java
   ObjectAnimator translation = ObjectAnimator.ofFloat(imageview, "alpha", 0)
   ```

   크기 정하기 //안하기

   크기 바꾸기

   ```java
   ObjectAnimator alpha = ObjectAnimator.ofFloat(imageview, "scaleY", 2);
   ```

3. control

   기다리기

   ```java
   alpha.setDuration(1000); - default(300)
   ```

   반복하기

   ```java
   animSet.addListener(new AnimatorListenerAdapter() {
               int num = 3;
               @Override
               public void onAnimationEnd(Animator animation) {
                   if(num > 1) {
                       animation.start();
                       num--;
                   }
               }
           });
   ```

   만약 ~라면
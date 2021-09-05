|ㅡCodeActivity

|——CodeBlockPage(tablayout + viewPager)

|————— CodePagerAdapter(Fragment들 연결 Adapter)

|——————— CodeRecylcerView(ViewPager내에 보일 RecylcerView)

|—————————— Recyclerview_Code_ItemAdapter(RecyclerView에 보일 Data 정리)

|—————————— CodeRecyclerview_ItemDecoration(RecyclerView 마진값)

Block

|—BlockItems(BlockItem을 모아놓은 ArrayList)

|——BlockItem(각 Block들에 대한 model)

|———Calculation

|———Control

|———Event

|———Motion

|———Shape

|———Variable

|———(Object)



**Control**

control_if

control_ifelse

control_repeat

control_wait



**Event**

event_click_exceptxy_medium

event_click_exceptxy_start

event_clickxy_medium

event_clickxy_start

event_object_clicked_medium

event_object_clicked_start

event_play_clicked

event_receive_signal

event_send_signal_andwait

event_send_signal

**Looks**

looks_change_scale

looks_go_backward

looks_go_forward

looks_go_very_front

looks_hide

looks_say

looks_stop

looks_set_scale

looks_show

**Motion**

motion_change

motion_rotate_left

motion_rotate_right

motion_set
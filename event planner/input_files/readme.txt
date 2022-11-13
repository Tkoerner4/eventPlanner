========================================
in1.txt (add one event)
========================================
	1. list current events (expected to be empty/0 event)
	2. add an event
	3. list current events, expected output:
----------------------------------------
Current planner has 1 event(s).
----------------------------------------
[0]06:30-07:00/breakfast
----------------------------------------
	4. exit
	
	
	
========================================
in2.txt (add multiple events in order)
========================================
	1. list current events (expected to be empty/0 event)
	2. add an event (06:30-07:00/breakfast)
	3. add an event (09:00-10:15/CS310-001)
	4. add an event (10:30-12:30/CS310 office hour)
	5. list current events, expected output:
----------------------------------------
Current planner has 3 event(s).
----------------------------------------
[0]06:30-07:00/breakfast
[1]09:00-10:15/CS310-001
[2]10:30-12:30/CS310 office hour
----------------------------------------
	6. exit

	
========================================
in3.txt (add multiple events not in order)
========================================
	1. list current events (expected to be empty/0 event)
	2. add an event (13:30-14:45/CS310-002)
	3. add an event (09:00-10:15/CS310-001)
	4. add an event (10:30-12:30/CS310 office hour)
	5. list current events, expected output:
----------------------------------------
Current planner has 3 event(s).
----------------------------------------
[0]09:00-10:15/CS310-001
[1]10:30-12:30/CS310 office hour
[2]13:30-14:45/CS310-002
----------------------------------------
	6. exit
	
	
========================================
in4.txt (add multiple events + change start time)
========================================
	1. add an event (06:00-06:30/breakfast)
	2. add an event (06:40-07:40/jogging)
	3. add an event (07:00-08:00/morning news)
	4. list current events, expected output:
----------------------------------------
Current planner has 3 event(s).
----------------------------------------
[0]06:00-06:30/breakfast
[1]06:40-07:40/jogging
[2]07:00-08:00/morning news
----------------------------------------
	5. change start of jogging to be 7:00
	6. list current events, expected output (note the unchanged order):
----------------------------------------
Current planner has 3 event(s).
----------------------------------------
[0]06:00-06:30/breakfast
[1]07:00-08:00/jogging
[2]07:00-08:00/morning news
----------------------------------------
	7. change start of jogging to be 5:00
	8. list current events, expected output (note the changed order):
----------------------------------------
Current planner has 3 event(s).
----------------------------------------
[0]05:00-06:00/jogging
[1]06:00-06:30/breakfast
[2]07:00-08:00/morning news
----------------------------------------
	9. exit
	
	
	
========================================
in5.txt (add events + change duration)
========================================
	1. add an event (23:30-23:59/snack)
	2. add an event (23:00-23:35/game)
	3. list current events, expected output:
----------------------------------------	
	Current planner has 2 event(s).
----------------------------------------
[0]23:00-23:35/game
[1]23:30-23:59/snack
----------------------------------------
	4. change duration of snack to be 10 minutes
	5. change duration of game to be 60 minutes (fail to change)
	6. list current events, expected output:
----------------------------------------	
	Current planner has 2 event(s).
----------------------------------------	
[0]23:00-23:35/game
[1]23:30-23:40/snack
----------------------------------------	
	7. change duration of game to be 59 minutes
	8. list current events, expected output:	
----------------------------------------
Current planner has 2 event(s).
----------------------------------------
[0]23:00-23:59/game
[1]23:30-23:40/snack
----------------------------------------
	9. exit


========================================
in6.txt (add events + remove events)
========================================
	1. add an event (13:30-14:45/CS310-002)
	2. add an event (09:00-10:15/CS310-001)
	3. add an event (10:30-12:30/CS310 office hour)
	4. add an event (12:00-12:30/lunch)
	5. add an event (15:00-16:00/CS310 Meeting)
	6. list current events, expected output:
----------------------------------------
Current planner has 5 event(s).
----------------------------------------
[0]09:00-10:15/CS310-001
[1]10:30-12:30/CS310 office hour
[2]12:00-12:30/lunch
[3]13:30-14:45/CS310-002
[4]15:00-16:00/CS310 Meeting
----------------------------------------
	7. remove event no. 7 (invalid number)
	8. list current events, expected no change from above, details omitted
	9. remove event no. 2
	10. list current events, expected output:
----------------------------------------
Current planner has 4 event(s).
----------------------------------------
[0]09:00-10:15/CS310-001
[1]10:30-12:30/CS310 office hour
[2]13:30-14:45/CS310-002
[3]15:00-16:00/CS310 Meeting
----------------------------------------
	11. remove event no. 3
	12. list current events, expected output:
----------------------------------------
	Current planner has 3 event(s).
----------------------------------------
[0]09:00-10:15/CS310-001
[1]10:30-12:30/CS310 office hour
[2]13:30-14:45/CS310-002
----------------------------------------
	13. exit



========================================
in7.txt (add events + change description)
========================================
	1. add an event (07:00-07:10/wake-up)
	2. add an event (07:10-23:00/working)
	3. list current events, expected output:
----------------------------------------
Current planner has 2 event(s).
----------------------------------------
[0]07:00-07:10/wake-up
[1]07:10-23:00/working
----------------------------------------
	4. change description of event 1 to be "day-dreaming"
	5. list current events, expected output:
----------------------------------------
Current planner has 2 event(s).
----------------------------------------
[0]07:00-07:10/wake-up
[1]07:10-23:00/day-dreaming
---------------------------------------
	6. exit
	
	
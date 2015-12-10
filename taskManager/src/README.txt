
CS442 Design Patterns
Spring 2015
PROJECT TASK MANAGER README FILE

Due Date: Friday, April 3, 2015
Submission Date: Friday, April 3, 2015
Grace Period Used This Project: 0 days
Grace Period Remaining: 0 days
Author(s): Alexander P Valera
e-mail(s): avalera1@binghamton.edu


PURPOSE:

[
  Purpose of this project is to implement a clean observer pattern and to simulate
  a windows task manager dashboard with "realtime" updates
]

PERCENT COMPLETE:

[
   I believe I have completed 99.9% of the project. 
]

PARTS THAT ARE NOT COMPLETE:

[
 N/A
]

BUGS:

[
  None
]

FILES:

[
  Driver.java - Runs the entire program, reads file
  FileProcessor.java - Writes to output file
  DashboardSubject.java - Implements subject interface, sends data to observers
  Subject.java - interface
  Observer.java - interface
  ProcessesTab.java - Holds processes information
  UsersTab.java - Holds user information
  PerformanceTab.java - Holds performance information
  PerformanceTabFilterImpl.java - filters performance
  UsersTabFilterImpl.java - filters users
  ProcessesTabFilterImpl.java - filters processes
  DisplayFile.java - interface
  DashboardFilter.java -interface 


]

SAMPLE OUTPUT:

[

Just a snippet from output.txt

---PROCESSES---
  PID COMMAND         USER     %CPU %MEM
 1881 gdb             dgolemb1  0.0  0.7
 3203 Xorg            root      0.0  0.1
 3994 getty           root      0.0  0.0
 3995 getty           root      0.0  0.0
 3996 getty           root      0.0  0.0
 3997 getty           root      0.0  0.0
 3998 getty           root      0.0  0.0
 3999 getty           root      0.0  0.0
 5393 tcsh            ndangwa1  0.0  0.1
 5975 tcsh            dgolemb1  0.0  0.1
 7377 bash            root      0.0  0.0
 7581 watch           root      0.0  0.0
17264 gdb             dgolemb1  0.0  0.7
17528 tcsh            bsendir1  0.0  0.1
17674 bomb            dgolemb1  0.0  0.0
18090 tcsh            tkargul1  0.0  0.1
18108 nano            ndangwa1  1.3  0.2
18116 tcsh            dgolemb1  0.0  0.1
18151 python          bsendir1  0.3  0.4
18269 sh              bsendir1  0.0  0.0
18270 ps              bsendir1  0.0  0.0
18666 bash            mslocum1  0.0  0.1
27983 vim             mslocum1  0.0  0.8
28029 tcsh            cigdebe1  0.0  0.1
30920 tcsh            rashong1  0.0  0.1
31023 gdb             rashong1  0.0  0.7
31358 bomb            rashong1  0.0  0.0
31444 tcsh            awiesin1  0.0  0.1
32380 emacs           awiesin1  0.0  0.9
]

TO COMPILE:

[
  Go to the taskManager directory and type in 
  ant -buildfile src/buildfile.xml
]

TO RUN:

[
  Please run as:

  ant -buildfile src/buildfile.xml -Darg0=infile -Darg1=debugLevel

  Example:

  ant -buildfile src/buildfile.xml -Darg0=src/taskManager/infile.txt -Darg1=1


]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

[
http://javarevisited.blogspot.com/2014/05/double-checked-locking-on-singleton-in-java.html
]

ACKNOWLEDGEMENT:

[
  Kevin Olango
  Mark Fishkin
  Ridwan Olatilewa

]
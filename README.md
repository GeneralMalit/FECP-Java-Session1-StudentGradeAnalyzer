# General Malit
### Mini Capstone - Student Grade Analyzer
![img.png](img.png)

note: the checker was failing on lab 4 because of my approach with the scanner. I have created the scanner object as a global 
```commandline
public Static Scanner sc =  new Scanner(System.in)
```
rather than within the local method. The global object approach was more convenient for being able to scan within other methods, but might not be best practice for resource management reasons. 
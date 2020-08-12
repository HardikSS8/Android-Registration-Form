# Android-Registration-Form
This repository is a simple registration form app with all validation functionality developed in the android studio.

#### -> Main purpose of this repository is to show how to use SQLite database in android studio to store the data entered in form and            display on to the next page of app.

#### -> Here SQLite Database is created which can be found on DatabaseHelper class in the main folder of this app.


## Getting Setup
1. Download Android Studio: [https://developer.android.com/studio](https://developer.android.com/studio)

2. Clone or download this repository <br/>

   -> Instructions on how to clone/download a GitHub repo: [https://help.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository](https://help.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository)
           
3. Open Android Studio and Import the project:
      
        File -> New -> Import Project
   -> Select the project folder - aka the project you just cloned/downloaded from GitHub     

4. Set up the Android Emulator, so you can run Android devices on your computer
        
        Tools -> AVD Manager -> Create virtual device
   -> After that click finish and start the emulator using play button in AVD Manager

## Validation of Form

1. InputFilter functionality is used for adding limit on first and last name to contain only letters and also upto some max      length.

2. For the email and date validation, these two patterns is applied:
    
       1. emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
       2. datePattern = "^(1[0-2]|0[1-9])/(3[01]" + "|[12][0-9]|0[1-9])/[0-9]{4}$";

3. setError is used to show different-different errors on all fields of form as displayed in the given following section of        interface.

## Interface of Form 

Interface(Layout) of this registration form can be found in activity_main.xml file in the layout folder of this app.
<br />

<img src="https://user-images.githubusercontent.com/35401920/79697333-c8e3ba80-829f-11ea-9733-d0488f2c4685.png" width=350>
<br />

setError is shown as below.

<br />

<img src="https://user-images.githubusercontent.com/35401920/79697337-cbdeab00-829f-11ea-9ad7-f6d4d976ab67.png" width=350>

<br />

After adding the valid details in the text field error will be gone.

<br /> 

<img src="https://user-images.githubusercontent.com/35401920/85198949-c4706800-b309-11ea-8334-ace8b2510506.png" width=350>

<br />

Finally after clicking on register, all entered data of that user will be erased and user can see the details on the next page of app.

<br />

<img src="https://user-images.githubusercontent.com/35401920/79697338-cda86e80-829f-11ea-9789-ab102a47e7a6.png" width=350>

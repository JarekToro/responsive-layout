Responsive Layout
===================

> Vaadin is great! Responsive webpages are great! ... 
> 
> ![alt text](http://emojipedia-us.s3.amazonaws.com/cache/e4/9e/e49e33767a64cf63310af3764fc60126.png "hey")
> 
>  *Wait a minute!! lets put them together!*







Todo
----------
| Task             | Description           | Status         |
| :--------------- | :-------------------- | :---:          |
| Remove **all** need for Vertical and Horizontal Layout! | mind = blown |   **Layouts, Watch out!**    |


 
<br>

### features
------------------

 * Easily move from Vertical or Horizontal Layouts (uses same api)
 * Removes Vertical Horizontal Soup from your code
 * **Performance Boost** very lightweight layout
 * Looks great everywhere


Wanna do this? Yeah you do!

![Image of radness](https://raw.githubusercontent.com/Jayrok94/ResponsiveLayout/master/readme-resources/demo.gif)

How do i build this? That complex dynamic menu.. I need.. Well its all super simple. :+1:

> *Note:* If you are new to the responsive grid pattern then as you look at the code read the comments
>
> *P.S Note* without the comments this is all accomplished with only 50 lines of code!

### Lets start with the layout [Here is what where making](https://raw.githubusercontent.com/Jayrok94/ResponsiveLayout/master/readme-resources/stage1.PNG)

```java


 protected void init(VaadinRequest vaadinRequest) {

         @Override
            protected void init(VaadinRequest vaadinRequest) {


                setSizeFull(); // set the size of you UI to fill the screen


					// Here is where the magic happens
                ResponsiveLayout responsiveLayout = new ResponsiveLayout();
                responsiveLayout.setSizeFull();



					// ResponsiveLayouts have rows
					// Our first row will contain our 2 Columns
					// The Menu Column & the Main Column
                Row rootRow = new Row();
                rootRow.setHeight("100%");
                responsiveLayout.addRow(rootRow);
```
> Lets take a second to explain how columns and rows work
>
> A Row splits up the page horizontally. You'll need a few of these to break up the content.
>
> A column divides the row into vertical spaces within the row. They can take up to 1/12 of the space all the way to 12/12 of the spaces.

**Ok back to the code**

```

					// Here we take the side menu and assign the amount of spaces
					// we want the column to take depending
					// on the size of the screen we are on.
					// So for the side menu is takes up 12/12 spaces on a mobile phone and tablet
					// Then on computer screens and wide screen monitors it only takes up 2/12;
                Column sideMenuCol = new Column(12, 12, 2, 2);

                // The main Column also takes up 12/12 on the mobile and tablet.
                // But for computer screens we want to have it to the right of the Menu
                // so we tell it 10/12
                Column mainSectionCol = new Column(12, 12, 10, 10);

                rootRow.addColumn(sideMenuCol);
                rootRow.addColumn(mainContentCol);

                mainSectionLayout.addRow(testSubjectsRow);

                setContent(responsiveLayout);


```


### So now that the layout is there lets add the Menu [Here is what where making now](https://raw.githubusercontent.com/Jayrok94/ResponsiveLayout/master/readme-resources/stage2.PNG)
___________________________________________



```java


// continuing from last code blurb


					// The menu itself is just a Row
					// Oh did i mention that rows and columns are nestable - Rad

                Row menu = new Row();

					// This is the profile image we just set 12
					// because no matter what we want 12/12 spaces taken
                Column profileCol = new Column(12);
                profileCol.setComponent(image);

					// For the menu buttons they need to be going from top to bottom
					// while on a computer then go left to right while on tablet then
					// go back to top and bottom while on phones

					// Because Rows wrap there content
					// if each Column has a width of 12
					// they will just stack on top of each other
					// so for mobile and computers we say 12

					// For tablets we give each column 3
					// 3+3+3+3 = 12
					// 4 buttons will fit perfectly in one row

                Column homeCol = new Column(12, 3, 12);
                homeCol(/* button, label, etc */);

                Column testersCol = new Column(12, 3, 12);
                testersCol(/* button, label, etc */);
                testersCol(Column.DisplaySize.XS, false);

                Column analyzeCol = new Column(12, 3, 12);
                analyzeCol(/* button, label, etc */);

                // We can also set the visibility depending on what screen they are on
                // this hids the menu buttons when on mobile

                analyzeCol(Column.DisplaySize.XS, false);

                Column reportCol = new Column(12, 3, 12);
                reportCol(/* button, label, etc */);
                reportCol(Column.DisplaySize.XS, false);

                menu.addColumn(profileCol);
                menu.addColumn(homeCol);
                menu.addColumn(testersCol);
                menu.addColumn(analyzeCol);
                menu.addColumn(reportCol);

                sideMenuCol.setComponent(menu);



```


### and now setting the main content [final product](https://raw.githubusercontent.com/Jayrok94/ResponsiveLayout/master/readme-resources/stage3.PNG)

```


					// Here we are creating a new responsiveLayout to house the multiple rows
					// for the main content

 					ResponsiveLayout mainContentLayout = new ResponsiveLayout();

                mainContentCol.setComponent(mainContentLayout);


					// simple row with one column that takes 3/12 spaces
					// and then the row centers that column to the middle
                Row titleRow = new Row();
                Column titleCol = new Column(3);
                titleRow.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

                Label title = new Label("Test Subjects");

                titleCol.setComponent(title);
                titleRow.addColumn(titleCol);
                titleRow.setMargin(true);
                mainSectionLayout.addRow(titleRow);


					// Here we have a new Row just for the test subjects

                Row testSubjectsRow = new Row();

                for (int x = 0; x < 10; x++) {

                // We want each column to take
                // 12/12 on mobile
                // 6/12 on tablet
                // 4/12 on computer screens
                // 3/12 on wide computer screens

                    Column testerCol = new Column(12, 6, 4, 3);
                    testerCol.setComponant(new Panel());
                    testSubjectsRow.addColumn(testerCol);

                }

					// sets spacing between the columns and margin around the whole row

                testSubjectsRow.setHorizontalSpacing(true);
                testSubjectsRow.setVerticalSpacing(true);
                testSubjectsRow.setMargin(true);

                mainSectionLayout.addRow(testSubjectsRow);


                setContent(responsiveLayout);
            }
    }

```


## Tada!
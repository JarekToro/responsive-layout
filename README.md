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


Looks totally rad!

[Image of radness](https://raw.githubusercontent.com/Jayrok94/ResponsiveLayout/master/demo.gif)


Here is the code! Even builds the menu in like 15 lines :+1:

```java
 protected void init(VaadinRequest vaadinRequest) {

         @Override
            protected void init(VaadinRequest vaadinRequest) {

                setSizeFull();

                ResponsiveLayout responsiveLayout = new ResponsiveLayout();
                responsiveLayout.setSizeFull();


                Row rootRow = new Row();
                rootRow.setHeight("100%");
                responsiveLayout.addRow(rootRow);


                Column sideMenuCol = new Column(12, 12, 2, 2);
                Column mainSectionCol = new Column(12, 12, 10, 10);

                rootRow.addColumn(sideMenuCol);
                rootRow.addColumn(mainSectionCol);


                Row menu = new Row();

                Column profileCol = new Column(12);
                profileCol.setComponent(image);
                profileCol.addStyleName("content-center");

                Column logoCol = new Column(12, 3, 12);
                logoCol.setComponent(mainlogobutton);

                Column homeCol = new Column(12, 3, 12);
                homeCol.setComponent(/* button, label, etc */);
                homeCol.setVisibility(Column.DisplaySize.XS, false);

                Column aboutCol = new Column(12, 3, 12);
                aboutCol.setComponent(/* button, label, etc */);
                aboutCol.setVisibility(Column.DisplaySize.XS, false);

                Column contactCol = new Column(12, 3, 12);
                contactCol.setComponent(/* button, label, etc */);
                contactCol.setVisibility(Column.DisplaySize.XS, false);

                menu.addColumn(profileCol);
                menu.addColumn(logoCol);
                menu.addColumn(homeCol);
                menu.addColumn(aboutCol);
                menu.addColumn(contactCol);

                sideMenuCol.setComponent(menu);


                ResponsiveLayout mainSectionLayout = new ResponsiveLayout();


                mainSectionCol.setComponent(mainSectionLayout);


                Row titleRow = new Row();
                Column titleCol = new Column(3);
                titleRow.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

                Label title = new Label("Test Subjects");

                titleCol.setComponent(title);
                titleRow.addColumn(titleCol);
                titleRow.setMargin(true);

                mainSectionLayout.addRow(titleRow);


                Row teamRow = new Row();

                for (int x = 0; x < 10; x++) {
                    TeamMemberView teamMemberView = new TeamMemberView();
                    teamRow.addColumn(teamMemberView.getInColumn(12, 6, 4, 3));
                }


                teamRow.setHorizontalSpacing(true);
                teamRow.setVerticalSpacing(true);
                teamRow.setMargin(true);

                mainSectionLayout.addRow(teamRow);


                setContent(responsiveLayout);
            }
    }

```


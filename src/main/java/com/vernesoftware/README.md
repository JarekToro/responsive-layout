Documentation
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



And here's some code! :+1:

```java
 protected void init(VaadinRequest vaadinRequest) {

        ResponsiveLayout responsiveLayout = new ResponsiveLayout();

        Row row = new RLRow();

        Column homeCol = new RLColumn(12, 3);
        homeCol.setOffset(RLColumn.DisplaySize.MD, 1);
        homeCol.setComponent(/* button, label, etc*/);

        Column aboutCol = new RLColumn(12, 3);
        aboutCol.setComponent(/* button, label, etc*/);

        Column contactCol = new RLColumn(12, 3);
        contactCol.setComponent(/* button, label, etc*/);

        row.setHorizontalSpacing(15);

        row.addColumn(homeCol);
        row.addColumn(aboutCol);
        row.addColumn(contactCol);


        responsiveLayout.addRow(row);


        setContent(responsiveLayout);
    }

```


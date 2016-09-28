Documentation
===================

Basic Structure
----------

![Image of diagram](https://raw.githubusercontent.com/Jayrok94/ResponsiveLayout/master/layoutdiagram.png)


### Key things to note
------------------

 * ResponsiveLayout and Row are subclassed from StyleDocumentAdapterCssLayout which gives them access to getCss() method which they use to dynamicly set the raw css of there objects;
 * Style Document Adapter is an interface which asks for getStyleDocument and setStyleDocument to be implemented
 * Column is subclassed from CustomComponant
 * A StyleDocument is a holder of css properties ' that is all '

> let me know what you think

> Upon further review i have been thinking: To make it more vaadin like we can actually remove all of the style document and style document adapter stuff. There sole purpose is to allow for a dynamic change of css variables so instead of setMargin(50px) you just do setMargin(true) and be happy with whats predefined.

> Since this is the case we can shelf the styleDocument for another project







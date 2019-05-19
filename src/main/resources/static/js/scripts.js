$(function() {
    booleanConverter();
});

function booleanConverter() {
var booleanClass = $(".booleanConvert");

  if(booleanClass.text() === "true") {
    booleanClass.text("Yes");
  } else {
    booleanClass.text("No");
  }
}



$(function() {
  var path = window.location.pathname;
  $('li[data-path="' + path + '"]').addClass('active');
});

$(function() {
  var path = window.location.pathname;
  $('[data-path="' + path + '"]').addClass('active');
});

function tpl_item(item) {
  var _out = '';
  item.images = JSON.parse(item.images);
  item.images[0] = item.images[0] || {};
  _out += '<div class="col-xs-12 col-sm-6 col-md-3">'
      + '<div class="card item">'
      + '<div class="cover">'
      +    '<img src="' + item.images[0].src + '" alt="cover">'
      +  '</div>'
      +  '<div class="caption">'
      +    '<h4>' + item.name + '</h4>'
      +    '<p>'+ item.description + '</p>'
      +    '<div class="detail-btn">'
      +      '<a href="/item/' + item.id + '" class="btn btn-default" role="button">查看详情</a>'
      +    '</div>'
      +  '</div>'
      + '</div>'
    + '</div>';
  return _out;
}

function tpl_item_admin_list(item) {
  var _out = '';
  _out += '<tr>'
    + '<td>'+item.id+'</td>'
    + '<td>'+item.name+'</td>'
    + '<td><a href="/admin/item/edit/'+item.id+'">编辑</a></td>'
  + '<tr>';
  return _out;
}

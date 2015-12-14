$ ->
  $.get "/tasks", (data) ->
    $.each data, (index, item) ->
      $("#tasks").append "<tr><td>" + item.id + "</td><td>" + item.description + "</td></tr>"
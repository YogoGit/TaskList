$ ->
  $.get "/tasks", (data) ->
    $.each data, (index, item) ->
      $("#tasks").append "<li>Task " + item.description + "</li>"

$('document').ready(function (){
    $('table #editButton').on('click',function (event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(city){
            $('#idEdit').val(city.id);
            $('#nameEdit').val(city.name);
            $('#codeEdit').val(city.code);
            $('#detailsEdit').val(city.details);
        });

        $('#editModal').modal();
    });

    $('table #deleteButton').on('click',function (event){
        event.preventDefault();

        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href',href);

        $('#deleteModal').modal();
    });

    $('table #detailsButton').on('click',function (event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(city){
            $('#idView').val(city.id);
            $('#nameView').val(city.name);
            $('#codeView').val(city.code);
            $('#detailsView').val(city.details);
        });

        $('#detailsModal').modal();
    });


});

$('document').ready(function (){
    $('table #editButton').on('click',function (event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(asset){
            $('#idEdit').val(asset.id);
            $('#nameEdit').val(asset.name);
            $('#typeEdit').val(asset.assetType);
            $('#numberEdit').val(asset.assetNumber);
            $('#dateEdit').val(asset.registrationDate);
            $('#makeEdit').val(asset.assetMake);
            $('#statusEdit').val(asset.assetStatus);
            $('#modelEdit').val(asset.assetModel);
            $('#cityEdit').val(asset.currentCity);
            $('#remarksEdit').val(asset.remarks);
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
        $.get(href, function(asset){
            $('#idEdit').val(asset.id);
            $('#nameEdit').val(asset.name);
            $('#typeEdit').val(asset.assetType);
            $('#numberEdit').val(asset.assetNumber);
            $('#dateEdit').val(asset.registrationDate);
            $('#makeEdit').val(asset.assetMake);
            $('#statusEdit').val(asset.assetStatus);
            $('#modelEdit').val(asset.assetModel);
            $('#cityEdit').val(asset.currentCity);
            $('#remarksEdit').val(asset.remarks);
        });

        $('#detailsModal').modal();
    });


});
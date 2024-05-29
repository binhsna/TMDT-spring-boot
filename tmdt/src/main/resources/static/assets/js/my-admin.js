
/*Upload File */
$('#fileImage').change(function () {
    //
    const form = new FormData();
    form.append('fileImage', $(this)[0].files[0]);
    $.ajax({
        type: 'POST',
        dataType: 'JSON',
        data: form,
        url: '/upload-test',
        success: function (result) {
                $('#image_show').html('<a href="' + result.url + '" target="_blank">' +
                    '<img src="' + result.url + '" width="100px"></a>');
                $('#image').val(result.url);
        }
    });
});
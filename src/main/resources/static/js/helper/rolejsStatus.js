$(document).ready(function() {
    $('#roles').val('true');
});

//Bagian ini tolong cek Status nya
function editRole(param) {
    console.log(param);
    var idRole = $('#roleIdText' + param).text();
    var namaRole = $('#namaRoleText' + param).text();
    var activeRole = $('#statusRoleText' + param).text();

    $('.idRoleEdit').val(idRole);
    $('.namaRoleEdit').val(namaRole);
    $('.activeRoleEdit').val('true');
    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editRole').modal('toggle');
}
//periksa name

function removeRole(param) {
    var idRole = $('#roleIdText' + param).text();
    var namaRole = $('#namaRoleText' + param).text();
    console.log(idRole);
    $('.idRoleRemove').val(idRole);
    $('.namaRoleRemove').val(namaRole);
    $('.activeRoleRemove').val('false');
    $('.namaRoleRemoveText').text(namaRole);
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeRole').modal('toggle');
}


$(document).ready(function() {
    $('#roles').val('true');
});
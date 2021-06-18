$(document).ready(function() {
    $('#activeRole').val('true');
});


function editRole(param) {
    var idRole = $('#idRoleText' + param).text();
    var nameRole = $('#nameRoleText' + param).text();
    $('.idRoleEdit').val(idRole);
    $('.nameRoleEdit').val(nameRole);
    $('.activeRoleEdit').val('true');
    $('#edit-row-form').attr("action", "/role/edit/" + idRole);
    $('#editRole').modal('toggle');
}

function removeRole(param) {
    var idRole = $('#idRoleText' + param).text();
    var nameRole = $('#nameRoleText' + param).text();
    console.log(idRole);
    $('.idRoleRemove').val(idRole);
    $('.nameRoleRemove').val(nameRole);
    $('.activeRoleRemove').val('false');
    $('.nameRoleRemoveText').text(nameRole);
    $('#remove-row-form').attr("action", "/role/edit/" + idRole);
    $('#removeRole').modal('toggle');
}
$(function(){
    $('#alert-ok').hide();
    $('#alert-error').hide();
    listarFarm();
    
    crearFarm();
    eliminar();
});

function listarFarm(){
    let url = 'http://localhost:8080/api/Farm/all';
    $.getJSON(url).done(function(data){
        console.log(data);
        tbody = $('#tabla-farm tbody');
        //data [{},{},{}]
        $.each(data,function(index,item){
            let row = `<tr data-id=${item.id}><td>${item.name}</td><td>${item.address}</td><td>${item.exension}</td>
           <td> <button type="button" class="btn btn-success editar">Editar</button>
                        <button type="button" class="btn btn-danger eliminar">Eliminar</button></td></tr>`;

            tbody.append(row);
        });
    });
}

function crearFarm(){
    
    $("#add-btn").on('click',function(ev){
        ev.preventDefault();
        let inputname = $('#inputName').val();
        let inputaddress = $('#inputAddress').val();
        let inputexension = $('#inputExension').val();
        let url = 'http://localhost:8080/api/Farm/save';
        $.ajaxSetup({
            contentType: "application/json; charset=utf-8"
          });

        $.post( url, JSON.stringify({ name: inputname, address: inputaddress,exension: inputexension}) )
        .done(function(item){
            let tbody = $('#tabla-farm tbody');
            let row = `<tr data-id=${item.id}><td>${item.name}</td><td>${item.address}</td><td>${item.exension}</td>
                        <td><button type="button" class="btn btn-success editar">Editar</button>
                        <button type="button" class="btn btn-danger eliminar">Eliminar</button></td>
            </tr>`;
            tbody.append(row);
            var myModalEl = document.getElementById('fincaModal');
            var modal = bootstrap.Modal.getInstance(myModalEl)
            modal.hide()
            
            $('#alert-ok').html('<span>Finca creada correctamente</span>');
            $('#alert-ok').show();
            $('#alert-ok').hide(100);
            $('#alert-ok').html();
        })
        .fail(function(){
            $('#alert-error').html('<span>ERROR! No se pudo crear correctamente la finca</span>');
            $('#alert-error').show(100);
            $('#alert-error').html();
        });

    });
}

function eliminar(){
    $('#tabla-farm tbody').on('click','.eliminar', function(ev){
        ev.preventDefault();
        let tr = $(this).closest('tr');
        let id = tr.data('id');
        let myurl = 'http://localhost:8080/api/Farm/'+id;
        $.ajax({
            url:myurl,
            type:'DELETE',
            success:function(result){
                tr.remove();
            }
        });
      
    });
}
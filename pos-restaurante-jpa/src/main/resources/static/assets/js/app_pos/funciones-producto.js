//function cerrarNotificacion() {
//	$(".swal-overlay").removeClass("swal-overlay--show-modal");
//}

$(document).ready(
		function() {
			
			
			$(".btn_agregar_stok").on(
					"click",
					function() {
						var idProducto = $(this).parents("tr").find(
								"[id=id_producto_table]").html();
						var nombreProducto = $(this).parents("tr").find(
								"[id=nombre_producto_table]").html();
						var precioProducto = $(this).parents("tr").find(
								"[id=precio_producto_table]").html();
						$("#producto_id_stok_form").val(idProducto);
						$("#producto_nombre_stok_form").val(nombreProducto);
						$("#producto_precio_stok_form").val(precioProducto);
					});

		});
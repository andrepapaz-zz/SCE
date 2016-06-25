var empresaModel = angular.module('empresaModel', []);

empresaModel.controller("empresaController", function ($scope, $http) {

	original = undefined;
	urlEmpresa = 'rs/empresa';
	urlTipoEmpresa = 'rs/tipoEmpresa';

	$scope.pesquisaEmpresa = function () {
		$http.get(urlEmpresa).success(function(empresas) {
			$scope.empresas = empresas;
		}).error(function(erro) {
			$scope.errorMessage = erro;
			$('#myModal').modal('show');
		});
	};

	$scope.pesquisaTipoEmpresa =  function() {
		$http.get(urlTipoEmpresa).success(function(tipoEmpresas) {
			$scope.tipos = tipoEmpresas;
		}).error(function(erro) {
			$scope.errorMessage = erro;
			$('#myModal').modal('show');
		});
	};

	$scope.edditing = false;

	$scope.selecionaEmpresa = function(empresa) {
		original = angular.copy(empresa);
		$scope.empresa = empresa;
		$scope.edditing = true;
		$scope.textSubmit = 'Alterar';
	};

	$scope.cancel = function() {
		if (original != undefined) {
			angular.copy(original, $scope.empresa);
		}
		$scope.edditing = false;
	};

	$scope.novo = function() {
		$scope.mainForm.$setPristine();
		$scope.empresa = {};
		$scope.edditing = true;
		$scope.textSubmit = 'Incluir';
	};

	$scope.incluir = function(empresa) {
		if (empresa.codigo == undefined) {
			$http.post(urlEmpresa, empresa).success(function (empresa) {
				$scope.empresas.push(empresa);
				$scope.edditing = false;
			}).error(function (erro) {
				$scope.errorMessage = erro;
				$('#myModal').modal('show');
			})
		} else {
			$http.put(urlEmpresa, empresa).success(function (empresa) {
				$scope.pesquisaEmpresa();
				$scope.edditing = false;
			}).error(function (erro) {
				$scope.errorMessage = erro;
				$('#myModal').modal('show');
			})
		}
	};

	$scope.deletar = function(empresa) {
		if (empresa.codigo == undefined) {
			$scope.errorMessage = 'Selecione uma empresa';
			$('#myModal').modal('show');
		} else {
			urlExluir = urlEmpresa + "/" + empresa.codigo;
			$http.delete(urlExluir).success(function () {
				$scope.pesquisaEmpresa();
				$scope.errorMessage = 'Item Excluido!';
				$('#myModal').modal('show');
			}).error(function (erro) {
				$scope.errorMessage = erro;
				$('#myModal').modal('show');
			})
		}
	};

	$scope.pesquisaEmpresa();
	$scope.pesquisaTipoEmpresa();
})
;
var notaFiscalModel = angular.module('notaFiscalModel', []);

notaFiscalModel.controller("notaFiscalController", function ($scope, $http) {

	originalNF = undefined;
	$scope.tipoFilter = '';
	urlEmpresa = 'rs/empresa';
	urlTipoNF = 'rs/tipoNF';
	urlProduto = 'rs/produto';
	urlNotaFiscal = 'rs/notaFiscal';

	$scope.pesquisaNotaFiscal =  function() {
		$http.get(urlNotaFiscal).success(function(notasFiscais) {
			$scope.notasFiscais = notasFiscais;
		}).error(function(erro) {
			$scope.errorMessage = erro;
			$('#myModal').modal('show');
		});
	};

	$scope.pesquisaTipoNF =  function() {
		$http.get(urlTipoNF).success(function(tipoNFs) {
			$scope.tipos = tipoNFs;
		}).error(function(erro) {
			$scope.errorMessage = erro;
			$('#myModal').modal('show');
		});
	};

	$scope.pesquisaEmpresa = function () {
		$http.get(urlEmpresa).success(function(empresas) {
			$scope.empresas = empresas;
		}).error(function(erro) {
			$scope.errorMessage = erro;
			$('#myModal').modal('show');
		});
	};

	$scope.pesquisaProduto =  function() {
		$http.get(urlProduto).success(function(produtos) {
			$scope.produtos = produtos;
		}).error(function(erro) {
			$scope.errorMessage = erro;
			$('#myModal').modal('show');
		});
	};

	$scope.edditing = false;
	$scope.edditingItem = false;
	$scope.edittingLine = -1;
	$scope.bnewLine = false;
	$scope.item = {};

	$scope.selecionaNotaFiscal = function(notaFiscal) {
		originalNF = angular.copy(notaFiscal);
		$scope.notaFiscal = notaFiscal;
		$scope.edditing = true;
		$scope.bnewLine = false;
		$scope.textSubmit = 'Alterar';
	};

	$scope.cancel = function() {
		if (originalNF != undefined) {
			angular.copy(originalNF, $scope.notaFiscal);
		}
		$scope.edditing = false;
	};

	$scope.novo = function() {
		$scope.mainForm.$setPristine();
		$scope.notaFiscal = {};
		$scope.edditing = true;
		$scope.textSubmit = 'Incluir';
	};

	$scope.incluir = function(notaFiscal) {
		if (notaFiscal.codigo == undefined) {
			$http.post(urlNotaFiscal, notaFiscal).success(function (notaFiscal) {
				$scope.notasFiscais.push(notaFiscal);
				$scope.edditing = false;
			}).error(function (erro) {
				$scope.errorMessage = erro;
				$('#myModal').modal('show');
			})
		} else {
			$http.put(urlNotaFiscal, notaFiscal).success(function (notaFiscal) {
				$scope.pesquisaNotaFiscal();
				$scope.edditing = false;
			}).error(function (erro) {
				$scope.errorMessage = erro;
				$('#myModal').modal('show');
			})
		}
	};

	$scope.deletar = function(notaFiscal) {
		if (notaFiscal.codigo == undefined) {
			$scope.errorMessage = 'Selecione uma Nota Fiscal';
			$('#myModal').modal('show');
		} else {
			urlExluir = urlNotaFiscal + "/" + notaFiscal.codigo;
			$http.delete(urlExluir).success(function () {
				$scope.pesquisaNotaFiscal();
				$scope.errorMessage = 'Item Excluido!';
				$('#myModal').modal('show');
			}).error(function (erro) {
				$scope.errorMessage = erro;
				$('#myModal').modal('show');
			})
		}
	};

	$scope.newLine = function() {
		$scope.item = {};
		$scope.bnewLine = true;
	};

	$scope.alterLine = function (index, item) {
		if ($scope.edditingItem == false) {
			original = angular.copy(item);
			$scope.edditingItem = true;
			$scope.edittingLine = index;
		} else {
			$scope.edditingItem = false;
			$scope.edittingLine = -1;
		}
	};

	$scope.cancelLine = function (item) {
		if ($scope.edditingItem == true) {
			angular.copy(original, item);
			$scope.edditingItem = false;
			$scope.edittingLine = -1;
		} else {
			$scope.notaFiscal.itens.splice($scope.notaFiscal.itens.indexOf(item), 1);
		}
	};

	$scope.saveNewLine = function(item) {
		item.total = item.quantidade * item.valor;
		if ($scope.notaFiscal.itens == undefined) {
			$scope.notaFiscal.itens = [];
		}
		$scope.notaFiscal.itens.push(item);
		$scope.bnewLine = false;
	};

	$scope.cancelNewLine = function (index, item) {
		$scope.bnewLine = false;
	};

	$scope.getTotal = function(item) {
		if (item != undefined) {
			item.total = item.quantidade * item.valor;
			return item.total;
		} else {
			return 0;
		}
	};

	$scope.getTotalNF = function() {
		var total = 0;
		if ($scope.notaFiscal != undefined) {
			angular.forEach($scope.notaFiscal.itens, function(value, key) {
				total += value.total;
			});
			$scope.notaFiscal.valor = total;
		}

		return total;
	};

	$scope.filtrarEmpresa = function(tipo) {
		if (tipo == undefined) {
			$scope.tipoFilter = '';
		} else {
			if (tipo.codigo == 'E') {
				$scope.tipoFilter = 'F';
			} else {
				$scope.tipoFilter = 'C';
			}
		}
	};

	$scope.pesquisaNotaFiscal();
	$scope.pesquisaEmpresa();
	$scope.pesquisaTipoNF();
	$scope.pesquisaProduto();
})
;
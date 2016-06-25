var produtoModel = angular.module('produtoModel', []);

produtoModel.controller("produtoController", function ($scope, $http) {

	original = undefined;
	urlProduto = 'rs/produto';

	$scope.pesquisaProduto =  function() {
		$http.get(urlProduto).success(function(produtos) {
			$scope.produtos = produtos;
		}).error(function(erro) {
			$scope.errorMessage = erro;
			$('#myModal').modal('show');
		});
	};

	$scope.edditing = false;

	$scope.selecionaProduto = function(produto) {
		original = angular.copy(produto);
		$scope.produto = produto;
		$scope.edditing = true;
		$scope.textSubmit = 'Alterar';
	};

	$scope.cancel = function() {
		if (original != undefined) {
			angular.copy(original, $scope.produto);
		}
		$scope.edditing = false;
	};

	$scope.novo = function() {
		$scope.mainForm.$setPristine();
		$scope.produto = {};
		$scope.edditing = true;
		$scope.textSubmit = 'Incluir';
	};

	$scope.incluir = function(produto) {
		if (produto.codigo == undefined) {
			$http.post(urlProduto, produto).success(function (produto) {
				$scope.produtos.push(produto);
				$scope.edditing = false;
			}).error(function (erro) {
				$scope.errorMessage = erro;
				$('#myModal').modal('show');
			})
		} else {
			$http.put(urlProduto, produto).success(function (produto) {
				$scope.pesquisaProduto();
				$scope.edditing = false;
			}).error(function (erro) {
				$scope.errorMessage = erro;
				$('#myModal').modal('show');
			})
		}
	};

	$scope.deletar = function(produto) {
		if (produto.codigo == undefined) {
			$scope.errorMessage = 'Selecione um produto';
			$('#myModal').modal('show');
		} else {
			urlExluir = urlProduto + "/" + produto.codigo;
			$http.delete(urlExluir).success(function () {
				$scope.pesquisaProduto();
				$scope.errorMessage = 'Item Excluido!';
				$('#myModal').modal('show');
			}).error(function (erro) {
				$scope.errorMessage = erro;
				$('#myModal').modal('show');
			})
		}
	};

	$scope.pesquisaProduto();
});
<?php 
	require_once 'connection.php';
	abstract class Crud extends Conecction{
		private $table;
		private $pdo;

		public function _construct($table){
			$this->table=$table;
			$this->pdo=parent::conexion();
		}

		public function getAll(){
			$stm = $this->pdo->prepare("SELECT * FROM $this->table");
			$stm->execute();
			return $stm->fetchAll()
		}
	}
?>
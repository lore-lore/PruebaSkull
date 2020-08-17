<?php
	class Conexion{
		private $driver = 'mysql';
		private $host = 'localhost';
		private $user = 'root';
		private $pass = '';
		private $db = 'escuela';
		private $charset = 'utf8'

		protected function conexion(){
			try{
				$pdo = new PDO("{$this->driver}; host={$this->host}; dbname={$this->db}; charset={$this->charset}", $this->user, $this->pass);
				$pdo->setAtribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
				return $pdo;
			}catch(PDOException $e){
				echo $e->getMessage();
			}

		}
	}
?>
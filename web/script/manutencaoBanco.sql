ALTER TABLE `sce`.`itensnotafiscal`
DROP FOREIGN KEY `FK_129yob7974ooo7dh07hf08y5s`;
ALTER TABLE `sce`.`itensnotafiscal`
ADD CONSTRAINT `FK_129yob7974ooo7dh07hf08y5s`
  FOREIGN KEY (`idNf`)
  REFERENCES `sce`.`notafiscal` (`id`)
  ON DELETE CASCADE;
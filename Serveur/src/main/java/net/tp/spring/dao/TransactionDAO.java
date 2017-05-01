package net.tp.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.tp.spring.model.Debiteur;
import net.tp.spring.model.CompteDebiteur;
import net.tp.spring.model.DebtorAgent;
import net.tp.spring.model.DirectDebitTransaction;
import net.tp.spring.model.DrctDbtTxInf;
import net.tp.spring.model.DrctDbtTxInfResume;
import net.tp.spring.model.FinalInstitutionIdentifier;
import net.tp.spring.model.Id;
import net.tp.spring.model.MandateRelatedInformation;
import net.tp.spring.model.Statistique;

public class TransactionDAO implements ITransactionDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public TransactionDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*Ajouter une nouvelle transaction à la base de données*/
	@Override
	public void add(DrctDbtTxInf DrctDbtTxInf) {
		// insert
		String sql = "INSERT INTO transaction (num, PmtId, InstdAmt, MndtId, DtOfSgntr, "
				+ "BIC, Nm, IBAN, RmtInf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, DrctDbtTxInf.getNumero(), DrctDbtTxInf.getIdenPaim(), DrctDbtTxInf.getMontInst(), 
				DrctDbtTxInf.getTransDebit().getInformMandat().getIdentMnd(), 
				DrctDbtTxInf.getTransDebit().getInformMandat().getDateSgntr()
				, DrctDbtTxInf.getAgentDebit().getIdentifinst().getBIC(), DrctDbtTxInf.getDebiteur().getName(), 
				DrctDbtTxInf.getComptDebit().getIdentifiant().getIBAN(), DrctDbtTxInf.getInfRemise());
	}

	/*Rechercher une transaction identifiée par pmtId dans la base de données*/
	@Override
	public DrctDbtTxInf get(String pmtId) {
		String sql = "SELECT * FROM transaction WHERE PmtId='" + pmtId +"'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<DrctDbtTxInf>() {

			public DrctDbtTxInf extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					return new DrctDbtTxInf(rs.getInt("transaction_id"),
							rs.getString("num"),rs.getString("PmtId"),rs.getDouble("InstdAmt"), 
							new DirectDebitTransaction((new MandateRelatedInformation(rs.getString("MndtId"),rs.getString("DtOfSgntr")))),
							new DebtorAgent(new FinalInstitutionIdentifier(rs.getString("BIC"))),new Debiteur(rs.getString("Nm")), 
							new CompteDebiteur(new Id(rs.getString("IBAN"))),rs.getString("RmtInf"));
				}
				
				return null;
			}
			
		});
	}

	//Retourne la valeur maximale de "transaction_id"
	@Override
	public int getMaxId() {
		return jdbcTemplate.queryForObject("SELECT MAX(transaction_id) FROM transaction", Integer.class);
	}

	/*Liste de toutes les transactions détaillées*/
	@Override
	public List<DrctDbtTxInf> list() {
		String sql = "SELECT * FROM transaction";
		List<DrctDbtTxInf> listTransactions = jdbcTemplate.query(sql, new RowMapper<DrctDbtTxInf>() {

			public DrctDbtTxInf mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DrctDbtTxInf(rs.getInt("transaction_id"),
						rs.getString("num"),rs.getString("PmtId"),rs.getDouble("InstdAmt"), 
						new DirectDebitTransaction((new MandateRelatedInformation(rs.getString("MndtId"),rs.getString("DtOfSgntr")))),
						new DebtorAgent(new FinalInstitutionIdentifier(rs.getString("BIC"))),new Debiteur(rs.getString("Nm")), 
						new CompteDebiteur(new Id(rs.getString("IBAN"))),rs.getString("RmtInf"));
				
			}
			
		});
		
		return listTransactions;
	}

	/*Liste de toutes les transactions résumées*/
	@Override
	public List<DrctDbtTxInfResume> listResume() {
		String sql = "SELECT * FROM transaction";
		List<DrctDbtTxInfResume> listTransactions = jdbcTemplate.query(sql, new RowMapper<DrctDbtTxInfResume>() {

			public DrctDbtTxInfResume mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DrctDbtTxInfResume(rs.getString("num"),rs.getString("PmtId"),rs.getDouble("InstdAmt"), 
						rs.getString("DtOfSgntr"));
				
			}
			
		});
		
		return listTransactions;
	}

	/*Retourne le nombre de transactions et le montant total des transactions dans la base de données*/
	@Override
	public Statistique getStats() {
		return new Statistique(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM transaction", Integer.class),
				jdbcTemplate.queryForObject("SELECT ROUND(SUM(InstdAmt),2) FROM transaction", Double.class));
	}

}

CREATE DEFINER=`root`@`%` TRIGGER `update_balance_paid_change` AFTER UPDATE ON `project_balance_paid` FOR EACH ROW begin

UPDATE project_balance_unpaid
SET sbf_gzsb_zx_zj_unpaid = (SELECT sbf_gzsb_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sbf_gzsb_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_gzsb_zc_zj_unpaid = (SELECT sbf_gzsb_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sbf_gzsb_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_szsb_zx_zj_unpaid = (SELECT sbf_szsb_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sbf_szsb_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_szsb_zc_zj_unpaid = (SELECT sbf_szsb_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sbf_szsb_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_sbsjgz_zx_zj_unpaid = (SELECT sbf_sbsjgz_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sbf_sbsjgz_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_sbsjgz_zc_zj_unpaid = (SELECT sbf_sbsjgz_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sbf_sbsjgz_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_sbzl_zx_zj_unpaid = (SELECT sbf_sbzl_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sbf_sbzl_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_sbzl_zc_zj_unpaid = (SELECT sbf_sbzl_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sbf_sbzl_zc_zj_paid
WHERE funds_id = NEW.funds_id;

-- 业务费

UPDATE project_balance_unpaid
SET ywf_zlf_zx_zj_unpaid = (SELECT ywf_zlf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_zlf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_zlf_zc_zj_unpaid = (SELECT ywf_zlf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_zlf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_sjybcjf_zx_zj_unpaid = (SELECT ywf_sjybcjf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_sjybcjf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_sjybcjf_zc_zj_unpaid = (SELECT ywf_sjybcjf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_sjybcjf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cshyjgf_zx_zj_unpaid = (SELECT ywf_cshyjgf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cshyjgf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cshyjgf_zc_zj_unpaid = (SELECT ywf_cshyjgf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cshyjgf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_rldlf_zx_zj_unpaid = (SELECT ywf_rldlf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_rldlf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_rldlf_zc_zj_unpaid = (SELECT ywf_rldlf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_rldlf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_bgf_zx_zj_unpaid = (SELECT ywf_bgf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_bgf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_bgf_zc_zj_unpaid = (SELECT ywf_bgf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_bgf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_yscbf_zx_zj_unpaid = (SELECT ywf_yscbf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_yscbf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_yscbf_zc_zj_unpaid = (SELECT ywf_yscbf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_yscbf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_zscqswf_zx_zj_unpaid = (SELECT ywf_zscqswf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_zscqswf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_zscqswf_zc_zj_unpaid = (SELECT ywf_zscqswf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_zscqswf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_clsyf_zx_zj_unpaid = (SELECT ywf_clsyf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_clsyf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_clsyf_zc_zj_unpaid = (SELECT ywf_clsyf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_clsyf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_chlf_zx_zj_unpaid = (SELECT ywf_chlf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_chlf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_chlf_zc_zj_unpaid = (SELECT ywf_chlf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_chlf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyhwf_zx_zj_unpaid = (SELECT ywf_hyhwf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_hyhwf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyhwf_zc_zj_unpaid = (SELECT ywf_hyhwf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_hyhwf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_gnxzf_zx_zj_unpaid = (SELECT ywf_gnxzf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_gnxzf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_gnxzf_zc_zj_unpaid = (SELECT ywf_gnxzf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_gnxzf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_gjhzjlf_zx_zj_unpaid = (SELECT ywf_gjhzjlf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_gjhzjlf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_gjhzjlf_zc_zj_unpaid = (SELECT ywf_gjhzjlf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_gjhzjlf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

--     UPDATE project_balance_unpaid
--     SET ywf_hyclgjhzyjlf_zx_zj_unpaid = (SELECT ywf_hyclgjhzyjlf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_hyclgjhzyjlf_zx_zj_paid
--     WHERE funds_id = NEW.funds_id;

--     UPDATE project_balance_unpaid
--     SET ywf_hyclgjhzyjlf_zc_zj_unpaid = (SELECT ywf_hyclgjhzyjlf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_hyclgjhzyjlf_zc_zj_paid
--     WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_hyf_zx_zj_unpaid = (SELECT ywf_hyclgjhzyjlf_hyf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_hyclgjhzyjlf_hyf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_hyf_zc_zj_unpaid = (SELECT ywf_hyclgjhzyjlf_hyf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_hyclgjhzyjlf_hyf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_clf_zx_zj_unpaid = (SELECT ywf_hyclgjhzyjlf_clf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_hyclgjhzyjlf_clf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_clf_zc_zj_unpaid = (SELECT ywf_hyclgjhzyjlf_clf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_hyclgjhzyjlf_clf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_gjhzf_zx_zj_unpaid = (SELECT ywf_hyclgjhzyjlf_gjhzf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_hyclgjhzyjlf_gjhzf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_gjhzf_zc_zj_unpaid = (SELECT ywf_hyclgjhzyjlf_gjhzf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_hyclgjhzyjlf_gjhzf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

--     UPDATE project_balance_unpaid
--     SET ywf_cbwxxxcbzscqswf_zx_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_zx_zj_paid
--     WHERE funds_id = NEW.funds_id;

--     UPDATE project_balance_unpaid
--     SET ywf_cbwxxxcbzscqswf_zc_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_zc_zj_paid
--     WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_zscqswf_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_zscqswf_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_zscqswf_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_zscqswf_zx_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_zscqswf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_zscqswf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_zscqswf_zc_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_zscqswf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_zscqswf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_ysdyzzf_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_ysdyzzf_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_ysdyzzf_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_ysdyzzf_zx_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_ysdyzzf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_ysdyzzf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_ysdyzzf_zc_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_ysdyzzf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_ysdyzzf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_wxsjkf_zx_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_wxsjkf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_wxsjkf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_wxsjkf_zc_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_wxsjkf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_wxsjkf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_xxcbf_zx_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_xxcbf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_xxcbf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_xxcbf_zc_zj_unpaid = (SELECT ywf_cbwxxxcbzscqswf_xxcbf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ywf_cbwxxxcbzscqswf_xxcbf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

-- 材料费

UPDATE project_balance_unpaid
SET clf_clf_zx_zj_unpaid = (SELECT clf_clf_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.clf_clf_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET clf_clf_zc_zj_unpaid = (SELECT clf_clf_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.clf_clf_zc_zj_paid
WHERE funds_id = NEW.funds_id;

-- 科研活动费

UPDATE project_balance_unpaid
SET kyhdf_zl_zx_zj_unpaid = (SELECT kyhdf_zl_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_zl_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_zl_zc_zj_unpaid = (SELECT kyhdf_zl_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_zl_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_cshyjg_zx_zj_unpaid = (SELECT kyhdf_cshyjg_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_cshyjg_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_cshyjg_zc_zj_unpaid = (SELECT kyhdf_cshyjg_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_cshyjg_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_bg_zx_zj_unpaid = (SELECT kyhdf_bg_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_bg_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_bg_zc_zj_unpaid = (SELECT kyhdf_bg_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_bg_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_sjybcj_zx_zj_unpaid = (SELECT kyhdf_sjybcj_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_sjybcj_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_sjybcj_zc_zj_unpaid = (SELECT kyhdf_sjybcj_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_sjybcj_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_yscb_zx_zj_unpaid = (SELECT kyhdf_yscb_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_yscb_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_yscb_zc_zj_unpaid = (SELECT kyhdf_yscb_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_yscb_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_zscqsw_zx_zj_unpaid = (SELECT kyhdf_zscqsw_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_zscqsw_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_zscqsw_zc_zj_unpaid = (SELECT kyhdf_zscqsw_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_zscqsw_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_rldl_zx_zj_unpaid = (SELECT kyhdf_rldl_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_rldl_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_rldl_zc_zj_unpaid = (SELECT kyhdf_rldl_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_rldl_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_clsy_zx_zj_unpaid = (SELECT kyhdf_clsy_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_clsy_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_clsy_zc_zj_unpaid = (SELECT kyhdf_clsy_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyhdf_clsy_zc_zj_paid
WHERE funds_id = NEW.funds_id;

-- 科研服务费

UPDATE project_balance_unpaid
SET kyfwf_zjzx_zx_zj_unpaid = (SELECT kyfwf_zjzx_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyfwf_zjzx_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_zjzx_zc_zj_unpaid = (SELECT kyfwf_zjzx_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyfwf_zjzx_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_cl_zx_zj_unpaid = (SELECT kyfwf_cl_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyfwf_cl_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_cl_zc_zj_unpaid = (SELECT kyfwf_cl_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyfwf_cl_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_hyhw_zx_zj_unpaid = (SELECT kyfwf_hyhw_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyfwf_hyhw_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_hyhw_zc_zj_unpaid = (SELECT kyfwf_hyhw_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyfwf_hyhw_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_gjhzjl_zx_zj_unpaid = (SELECT kyfwf_gjhzjl_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyfwf_gjhzjl_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_gjhzjl_zc_zj_unpaid = (SELECT kyfwf_gjhzjl_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyfwf_gjhzjl_zc_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_gnxz_zx_zj_unpaid = (SELECT kyfwf_gnxz_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyfwf_gnxz_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_gnxz_zc_zj_unpaid = (SELECT kyfwf_gnxz_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.kyfwf_gnxz_zc_zj_paid
WHERE funds_id = NEW.funds_id;

-- 人员和劳务补助费

UPDATE project_balance_unpaid
SET ryhlwbzf_rylw_zx_zj_unpaid = (SELECT ryhlwbzf_rylw_zx_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ryhlwbzf_rylw_zx_zj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ryhlwbzf_rylw_zc_zj_unpaid = (SELECT ryhlwbzf_rylw_zc_zj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.ryhlwbzf_rylw_zc_zj_paid
WHERE funds_id = NEW.funds_id;

-- 间接

UPDATE project_balance_unpaid
SET jxzc_zx_jj_unpaid = (SELECT jxzc_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.jxzc_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET jxzc_zc_jj_unpaid = (SELECT jxzc_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.jxzc_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET others_zx_unpaid = (SELECT others_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.others_zx_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET others_zc_unpaid = (SELECT others_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.others_zc_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_zx_jj_unpaid = (SELECT sbf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sbf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_zc_jj_unpaid = (SELECT sbf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sbf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET clf_zx_jj_unpaid = (SELECT clf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.clf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET clf_zc_jj_unpaid = (SELECT clf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.clf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET glf_zx_jj_unpaid = (SELECT glf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.glf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET glf_zc_jj_unpaid = (SELECT glf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.glf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET fwzjf_zx_jj_unpaid = (SELECT fwzjf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.fwzjf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET fwzjf_zc_jj_unpaid = (SELECT fwzjf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.fwzjf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET rcsdnf_zx_jj_unpaid = (SELECT rcsdnf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.rcsdnf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET rcsdnf_zc_jj_unpaid = (SELECT rcsdnf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.rcsdnf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zlf_zx_jj_unpaid = (SELECT zlf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.zlf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zlf_zc_jj_unpaid = (SELECT zlf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.zlf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sjybcjf_zx_jj_unpaid = (SELECT sjybcjf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sjybcjf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sjybcjf_zc_jj_unpaid = (SELECT sjybcjf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.sjybcjf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET cshyjgf_zx_jj_unpaid = (SELECT cshyjgf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.cshyjgf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET cshyjgf_zc_jj_unpaid = (SELECT cshyjgf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.cshyjgf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET rldlf_zx_jj_unpaid = (SELECT rldlf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.rldlf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET rldlf_zc_jj_unpaid = (SELECT rldlf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.rldlf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET bgf_zx_jj_unpaid = (SELECT bgf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.bgf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET bgf_zc_jj_unpaid = (SELECT bgf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.bgf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET yscbf_zx_jj_unpaid = (SELECT yscbf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.yscbf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET yscbf_zc_jj_unpaid = (SELECT yscbf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.yscbf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zscqswf_zx_jj_unpaid = (SELECT zscqswf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.zscqswf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zscqswf_zc_jj_unpaid = (SELECT zscqswf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.zscqswf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET clsyf_zx_jj_unpaid = (SELECT clsyf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.clsyf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET clsyf_zc_jj_unpaid = (SELECT clsyf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.clsyf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET chlf_zx_jj_unpaid = (SELECT chlf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.chlf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET chlf_zc_jj_unpaid = (SELECT chlf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.chlf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET hyhwf_zx_jj_unpaid = (SELECT hyhwf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.hyhwf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET hyhwf_zc_jj_unpaid = (SELECT hyhwf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.hyhwf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zjzxf_zx_jj_unpaid = (SELECT zjzxf_zx_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.zjzxf_zx_jj_paid
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zjzxf_zc_jj_unpaid = (SELECT zjzxf_zc_jj FROM project_funds WHERE funds_id = NEW.funds_id) - NEW.zjzxf_zc_jj_paid
WHERE funds_id = NEW.funds_id;

END

CREATE DEFINER=`root`@`%` TRIGGER `update_funds_change` AFTER UPDATE ON `project_funds` FOR EACH ROW begin

-- 设备费

UPDATE project_balance_unpaid
SET sbf_gzsb_zx_zj_unpaid = NEW.sbf_gzsb_zx_zj - (SELECT sbf_gzsb_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_gzsb_zc_zj_unpaid = NEW.sbf_gzsb_zc_zj - (SELECT sbf_gzsb_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_szsb_zx_zj_unpaid = NEW.sbf_szsb_zx_zj - (SELECT sbf_szsb_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_szsb_zc_zj_unpaid = NEW.sbf_szsb_zc_zj - (SELECT sbf_szsb_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_sbsjgz_zx_zj_unpaid = NEW.sbf_sbsjgz_zx_zj - (SELECT sbf_sbsjgz_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_sbsjgz_zc_zj_unpaid = NEW.sbf_sbsjgz_zc_zj - (SELECT sbf_sbsjgz_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_sbzl_zx_zj_unpaid = NEW.sbf_sbzl_zx_zj - (SELECT sbf_sbzl_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_sbzl_zc_zj_unpaid = NEW.sbf_sbzl_zc_zj - (SELECT sbf_sbzl_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

-- 业务费

UPDATE project_balance_unpaid
SET ywf_clf_zx_zj_unpaid = NEW.ywf_clf_zx_zj - (SELECT ywf_clf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_clf_zc_zj_unpaid = NEW.ywf_clf_zc_zj - (SELECT ywf_clf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_zlf_zx_zj_unpaid = NEW.ywf_zlf_zx_zj - (SELECT ywf_zlf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_zlf_zc_zj_unpaid = NEW.ywf_zlf_zc_zj - (SELECT ywf_zlf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_sjybcjf_zx_zj_unpaid = NEW.ywf_sjybcjf_zx_zj - (SELECT ywf_sjybcjf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_sjybcjf_zc_zj_unpaid = NEW.ywf_sjybcjf_zc_zj - (SELECT ywf_sjybcjf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cshyjgf_zx_zj_unpaid = NEW.ywf_cshyjgf_zx_zj - (SELECT ywf_cshyjgf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cshyjgf_zc_zj_unpaid = NEW.ywf_cshyjgf_zc_zj - (SELECT ywf_cshyjgf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_rldlf_zx_zj_unpaid = NEW.ywf_rldlf_zx_zj - (SELECT ywf_rldlf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_rldlf_zc_zj_unpaid = NEW.ywf_rldlf_zc_zj - (SELECT ywf_rldlf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_bgf_zx_zj_unpaid = NEW.ywf_bgf_zx_zj - (SELECT ywf_bgf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_bgf_zc_zj_unpaid = NEW.ywf_bgf_zc_zj - (SELECT ywf_bgf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_yscbf_zx_zj_unpaid = NEW.ywf_yscbf_zx_zj - (SELECT ywf_yscbf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_yscbf_zc_zj_unpaid = NEW.ywf_yscbf_zc_zj - (SELECT ywf_yscbf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_zscqswf_zx_zj_unpaid = NEW.ywf_zscqswf_zx_zj - (SELECT ywf_zscqswf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_zscqswf_zc_zj_unpaid = NEW.ywf_zscqswf_zc_zj - (SELECT ywf_zscqswf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_clsyf_zx_zj_unpaid = NEW.ywf_clsyf_zx_zj - (SELECT ywf_clsyf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_clsyf_zc_zj_unpaid = NEW.ywf_clsyf_zc_zj - (SELECT ywf_clsyf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_chlf_zx_zj_unpaid = NEW.ywf_chlf_zx_zj - (SELECT ywf_chlf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_chlf_zc_zj_unpaid = NEW.ywf_chlf_zc_zj - (SELECT ywf_chlf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyhwf_zx_zj_unpaid = NEW.ywf_hyhwf_zx_zj - (SELECT ywf_hyhwf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyhwf_zc_zj_unpaid = NEW.ywf_hyhwf_zc_zj - (SELECT ywf_hyhwf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_gnxzf_zx_zj_unpaid = NEW.ywf_gnxzf_zx_zj - (SELECT ywf_gnxzf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_gnxzf_zc_zj_unpaid = NEW.ywf_gnxzf_zc_zj - (SELECT ywf_gnxzf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_gjhzjlf_zx_zj_unpaid = NEW.ywf_gjhzjlf_zx_zj - (SELECT ywf_gjhzjlf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_gjhzjlf_zc_zj_unpaid = NEW.ywf_gjhzjlf_zc_zj - (SELECT ywf_gjhzjlf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

--     UPDATE project_balance_unpaid
--     SET ywf_hyclgjhzyjlf_zx_zj_unpaid = NEW.ywf_hyclgjhzyjlf_zx_zj - (SELECT ywf_hyclgjhzyjlf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
--     WHERE funds_id = NEW.funds_id;

--     UPDATE project_balance_unpaid
--     SET ywf_hyclgjhzyjlf_zc_zj_unpaid = NEW.ywf_hyclgjhzyjlf_zc_zj - (SELECT ywf_hyclgjhzyjlf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
--     WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_hyf_zx_zj_unpaid = NEW.ywf_hyclgjhzyjlf_hyf_zx_zj - (SELECT ywf_hyclgjhzyjlf_hyf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_hyf_zc_zj_unpaid = NEW.ywf_hyclgjhzyjlf_hyf_zc_zj - (SELECT ywf_hyclgjhzyjlf_hyf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_clf_zx_zj_unpaid = NEW.ywf_hyclgjhzyjlf_clf_zx_zj - (SELECT ywf_hyclgjhzyjlf_clf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_clf_zc_zj_unpaid = NEW.ywf_hyclgjhzyjlf_clf_zc_zj - (SELECT ywf_hyclgjhzyjlf_clf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_gjhzf_zx_zj_unpaid = NEW.ywf_hyclgjhzyjlf_gjhzf_zx_zj - (SELECT ywf_hyclgjhzyjlf_gjhzf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_hyclgjhzyjlf_gjhzf_zc_zj_unpaid = NEW.ywf_hyclgjhzyjlf_gjhzf_zc_zj - (SELECT ywf_hyclgjhzyjlf_gjhzf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

--     UPDATE project_balance_unpaid
--     SET ywf_cbwxxxcbzscqswf_zx_zj_unpaid = NEW.ywf_cbwxxxcbzscqswf_zx_zj - (SELECT ywf_cbwxxxcbzscqswf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
--     WHERE funds_id = NEW.funds_id;

--     UPDATE project_balance_unpaid
--     SET ywf_cbwxxxcbzscqswf_zc_zj_unpaid = NEW.ywf_cbwxxxcbzscqswf_zc_zj - (SELECT ywf_cbwxxxcbzscqswf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
--     WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_zscqswf_zx_zj_unpaid = NEW.ywf_cbwxxxcbzscqswf_zscqswf_zx_zj - (SELECT ywf_cbwxxxcbzscqswf_zscqswf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_zscqswf_zc_zj_unpaid = NEW.ywf_cbwxxxcbzscqswf_zscqswf_zc_zj - (SELECT ywf_cbwxxxcbzscqswf_zscqswf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_ysdyzzf_zx_zj_unpaid = NEW.ywf_cbwxxxcbzscqswf_ysdyzzf_zx_zj - (SELECT ywf_cbwxxxcbzscqswf_ysdyzzf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_ysdyzzf_zc_zj_unpaid = NEW.ywf_cbwxxxcbzscqswf_ysdyzzf_zc_zj - (SELECT ywf_cbwxxxcbzscqswf_ysdyzzf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_wxsjkf_zx_zj_unpaid = NEW.ywf_cbwxxxcbzscqswf_wxsjkf_zx_zj - (SELECT ywf_cbwxxxcbzscqswf_wxsjkf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_wxsjkf_zc_zj_unpaid = NEW.ywf_cbwxxxcbzscqswf_wxsjkf_zc_zj - (SELECT ywf_cbwxxxcbzscqswf_wxsjkf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_xxcbf_zx_zj_unpaid = NEW.ywf_cbwxxxcbzscqswf_xxcbf_zx_zj - (SELECT ywf_cbwxxxcbzscqswf_xxcbf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ywf_cbwxxxcbzscqswf_xxcbf_zc_zj_unpaid = NEW.ywf_cbwxxxcbzscqswf_xxcbf_zc_zj - (SELECT ywf_cbwxxxcbzscqswf_xxcbf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

-- 材料费

UPDATE project_balance_unpaid
SET clf_clf_zx_zj_unpaid = NEW.clf_clf_zx_zj - (SELECT clf_clf_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET clf_clf_zc_zj_unpaid = NEW.clf_clf_zc_zj - (SELECT clf_clf_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

-- 科研活动费

UPDATE project_balance_unpaid
SET kyhdf_zl_zx_zj_unpaid = NEW.kyhdf_zl_zx_zj - (SELECT kyhdf_zl_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_zl_zc_zj_unpaid = NEW.kyhdf_zl_zc_zj - (SELECT kyhdf_zl_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_cshyjg_zx_zj_unpaid = NEW.kyhdf_cshyjg_zx_zj - (SELECT kyhdf_cshyjg_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_cshyjg_zc_zj_unpaid = NEW.kyhdf_cshyjg_zc_zj - (SELECT kyhdf_cshyjg_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_bg_zx_zj_unpaid = NEW.kyhdf_bg_zx_zj - (SELECT kyhdf_bg_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_bg_zc_zj_unpaid = NEW.kyhdf_bg_zc_zj - (SELECT kyhdf_bg_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_zscqsw_zx_zj_unpaid = NEW.kyhdf_zscqsw_zx_zj - (SELECT kyhdf_zscqsw_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_zscqsw_zc_zj_unpaid = NEW.kyhdf_zscqsw_zc_zj - (SELECT kyhdf_zscqsw_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_rldl_zx_zj_unpaid = NEW.kyhdf_rldl_zx_zj - (SELECT kyhdf_rldl_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_rldl_zc_zj_unpaid = NEW.kyhdf_rldl_zc_zj - (SELECT kyhdf_rldl_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_clsy_zx_zj_unpaid = NEW.kyhdf_clsy_zx_zj - (SELECT kyhdf_clsy_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_clsy_zc_zj_unpaid = NEW.kyhdf_clsy_zc_zj - (SELECT kyhdf_clsy_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_sjybcj_zx_zj_unpaid = NEW.kyhdf_sjybcj_zx_zj - (SELECT kyhdf_sjybcj_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_sjybcj_zc_zj_unpaid = NEW.kyhdf_sjybcj_zc_zj - (SELECT kyhdf_sjybcj_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_yscb_zx_zj_unpaid = NEW.kyhdf_yscb_zx_zj - (SELECT kyhdf_yscb_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyhdf_yscb_zc_zj_unpaid = NEW.kyhdf_yscb_zc_zj - (SELECT kyhdf_yscb_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

-- 科研服务费

UPDATE project_balance_unpaid
SET kyfwf_zjzx_zx_zj_unpaid = NEW.kyfwf_zjzx_zx_zj - (SELECT kyfwf_zjzx_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_zjzx_zc_zj_unpaid = NEW.kyfwf_zjzx_zc_zj - (SELECT kyfwf_zjzx_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_cl_zx_zj_unpaid = NEW.kyfwf_cl_zx_zj - (SELECT kyfwf_cl_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_cl_zc_zj_unpaid = NEW.kyfwf_cl_zc_zj - (SELECT kyfwf_cl_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_hyhw_zx_zj_unpaid = NEW.kyfwf_hyhw_zx_zj - (SELECT kyfwf_hyhw_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_hyhw_zc_zj_unpaid = NEW.kyfwf_hyhw_zc_zj - (SELECT kyfwf_hyhw_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_gjhzjl_zx_zj_unpaid = NEW.kyfwf_gjhzjl_zx_zj - (SELECT kyfwf_gjhzjl_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_gjhzjl_zc_zj_unpaid = NEW.kyfwf_gjhzjl_zc_zj - (SELECT kyfwf_gjhzjl_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_gnxz_zx_zj_unpaid = NEW.kyfwf_gnxz_zx_zj - (SELECT kyfwf_gnxz_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET kyfwf_gnxz_zc_zj_unpaid = NEW.kyfwf_gnxz_zc_zj - (SELECT kyfwf_gnxz_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

-- 人员和劳务补助费

UPDATE project_balance_unpaid
SET ryhlwbzf_rylw_zx_zj_unpaid = NEW.ryhlwbzf_rylw_zx_zj - (SELECT ryhlwbzf_rylw_zx_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET ryhlwbzf_rylw_zc_zj_unpaid = NEW.ryhlwbzf_rylw_zc_zj - (SELECT ryhlwbzf_rylw_zc_zj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

-- 间接经费

UPDATE project_balance_unpaid
SET jxzc_zx_jj_unpaid = NEW.jxzc_zx_jj - (SELECT jxzc_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET jxzc_zc_jj_unpaid = NEW.jxzc_zc_jj - (SELECT jxzc_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET others_zx_unpaid = NEW.others_zx_jj - (SELECT others_zx_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET others_zc_unpaid = NEW.others_zc_jj - (SELECT others_zc_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_zx_jj_unpaid = NEW.sbf_zx_jj - (SELECT sbf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sbf_zc_jj_unpaid = NEW.sbf_zc_jj - (SELECT sbf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET clf_zx_jj_unpaid = NEW.clf_zx_jj - (SELECT clf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET clf_zc_jj_unpaid = NEW.clf_zc_jj - (SELECT clf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET glf_zx_jj_unpaid = NEW.glf_zx_jj - (SELECT glf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET glf_zc_jj_unpaid = NEW.glf_zc_jj - (SELECT glf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET fwzjf_zx_jj_unpaid = NEW.fwzjf_zx_jj - (SELECT fwzjf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET fwzjf_zc_jj_unpaid = NEW.fwzjf_zc_jj - (SELECT fwzjf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET rcsdnf_zx_jj_unpaid = NEW.rcsdnf_zx_jj - (SELECT rcsdnf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET rcsdnf_zc_jj_unpaid = NEW.rcsdnf_zc_jj - (SELECT rcsdnf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zlf_zx_jj_unpaid = NEW.zlf_zx_jj - (SELECT zlf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zlf_zc_jj_unpaid = NEW.zlf_zc_jj - (SELECT zlf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sjybcjf_zx_jj_unpaid = NEW.sjybcjf_zx_jj - (SELECT sjybcjf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET sjybcjf_zc_jj_unpaid = NEW.sjybcjf_zc_jj - (SELECT sjybcjf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET cshyjgf_zx_jj_unpaid = NEW.cshyjgf_zx_jj - (SELECT cshyjgf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET cshyjgf_zc_jj_unpaid = NEW.cshyjgf_zc_jj - (SELECT cshyjgf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET rldlf_zx_jj_unpaid = NEW.rldlf_zx_jj - (SELECT rldlf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET rldlf_zc_jj_unpaid = NEW.rldlf_zc_jj - (SELECT rldlf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET bgf_zx_jj_unpaid = NEW.bgf_zx_jj - (SELECT bgf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET bgf_zc_jj_unpaid = NEW.bgf_zc_jj - (SELECT bgf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET yscbf_zx_jj_unpaid = NEW.yscbf_zx_jj - (SELECT yscbf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET yscbf_zc_jj_unpaid = NEW.yscbf_zc_jj - (SELECT yscbf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zscqswf_zx_jj_unpaid = NEW.zscqswf_zx_jj - (SELECT zscqswf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zscqswf_zc_jj_unpaid = NEW.zscqswf_zc_jj - (SELECT zscqswf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET clsyf_zx_jj_unpaid = NEW.clsyf_zx_jj - (SELECT clsyf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET clsyf_zc_jj_unpaid = NEW.clsyf_zc_jj - (SELECT clsyf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET chlf_zx_jj_unpaid = NEW.chlf_zx_jj - (SELECT chlf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET chlf_zc_jj_unpaid = NEW.chlf_zc_jj - (SELECT chlf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET hyhwf_zx_jj_unpaid = NEW.hyhwf_zx_jj - (SELECT hyhwf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET hyhwf_zc_jj_unpaid = NEW.hyhwf_zc_jj - (SELECT hyhwf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zjzxf_zx_jj_unpaid = NEW.zjzxf_zx_jj - (SELECT zjzxf_zx_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

UPDATE project_balance_unpaid
SET zjzxf_zc_jj_unpaid = NEW.zjzxf_zc_jj - (SELECT zjzxf_zc_jj_paid FROM project_balance_paid WHERE funds_id = NEW.funds_id)
WHERE funds_id = NEW.funds_id;

end

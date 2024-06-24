import request from '@/utils/request'

// 查看支出信息
export function getExpenditure(bodyData, queryParam) {
    return request({
        url: '/project/funds/getProjectExpenditure',
        method: 'post',
        data: bodyData,
        params: queryParam,
    });
}

// 删除支出信息
export function rollbackExpenditure(expenditureId) {
    return request({
        url: '/project/funds/rollback',
        method: 'get',
        params: {
            expenditureId: expenditureId,
        },
    });
}

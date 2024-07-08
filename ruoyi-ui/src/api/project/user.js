import request from '@/utils/request'

export function getDetails(params) {
    return request({
        url: '/project/user/getDetails',
        method: 'get',
        params: params,
    });
}

// 查看用户列表
export function getAllList(data, params) {
    return request({
        url: '/project/user/getAllList',
        method: 'post',
        data: data,
        params: params,
    });
}

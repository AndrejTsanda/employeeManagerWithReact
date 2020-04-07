export const RECEIVE_BUILD_PROPERTIES = 'RECEIVE_BUILD_PROPERTIES';

export const receiveBuildProperties = (buildProperties) => ({
  type: RECEIVE_BUILD_PROPERTIES,
  buildProperties,
});